/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.addressbookmvc.dao;

import com.tsg.addressbookmvc.dto.Address;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
public class AddressBookDaoDbImpl implements AddressBookDAO {

    // #1 - All SQL code is in the form of Prepared Statements
    private static final String SQL_INSERT_ADDRESS     
            = "insert into addresses (firstName, lastName, address, city, state, zip) value (?,?,?,?,?,?)";

    private static final String SQL_DELETE_ADDRESS
            = "delete from addresses where addressID = ?";

    private static final String SQL_UPDATE_ADDRESS
            = "update addresses set firstName = ?, lastName = ?, address = ?, city = ?, state = ?, zip = ? where addressID = ?";

    private static final String SQL_SELECT_ALL_ADDRESSES = "select * from addresses";

    private static final String SQL_SELECT_ADDRESS = "select * from addresses where addressID = ?";

    // #2a - Declare JdbcTemplate reference - the instance will be handed to us by Spring
    private JdbcTemplate jdbcTemplate;

    // #2b - We are using Setter Injection to direct Spring to hand us an instance of
    // the JdbcTemplate (see the Spring Configuration section below for configuration
    // details).
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    // #3 - Wrap addAddress in a transaction so the we are guaranteed to get the
    // correct LAST_INSERT_ID for our row.
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Address addAddress(Address address) {
        jdbcTemplate.update(SQL_INSERT_ADDRESS,
                address.getFirstName(),
                address.getLastName(),
                address.getAddress(),
                address.getCity(),
                address.getState(),
                address.getZipCode());
        address.setAddressId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return address;
    }

    @Override
    public void removeAddress(int addressId) {
        jdbcTemplate.update(SQL_DELETE_ADDRESS, addressId);
    }

    @Override
    public void updateAddress(Address address) {
        jdbcTemplate.update(SQL_UPDATE_ADDRESS,
                address.getFirstName(),
                address.getLastName(),
                address.getAddress(),
                address.getCity(),
                address.getState(),
                address.getZipCode(),
                address.getAddressId());
    }

    @Override
    // #4 - getAllAddresses, getAddressById, searchAddressesByLastName, and
    // searchAddressesByAddress require us to pass in mapper
    // class to map the rows from the database into Address objects
    public List<Address> getAllAddresses() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ADDRESSES, new AddressMapper());
    }

    @Override
    public Address getAddressById(int addressId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ADDRESS, new AddressMapper(), addressId);
        } catch (EmptyResultDataAccessException e) {
            // there were no results for the given address id - we just want to
            // return null in this case
            return null;
        }
    }

    @Override
    public List<Address> searchAddress(Map<SearchTerm, String> criteria) {
        if (criteria.size() == 0) {
            return getAllAddresses();
        } else {
            StringBuilder sQuery = new StringBuilder("select * from addresses where ");
            int numParams = criteria.size();
            int paramPosition = 0;
            String[] paramVals = new String[numParams];
            Set<SearchTerm> keyset = criteria.keySet();
            Iterator<SearchTerm> iter = keyset.iterator();

            while (iter.hasNext()) {
                SearchTerm currentKey = iter.next();

                if (paramPosition > 0) {
                    sQuery.append(" and ");
                }

                sQuery.append(currentKey);
                sQuery.append(" = ? ");

                paramVals[paramPosition] = criteria.get(currentKey);
                paramPosition++;

            }
            return jdbcTemplate.query(sQuery.toString(), new AddressMapper(), paramVals);
        }

    }

    // #5 - This class maps the columns in the 'address’ table into properties on the
    // Address object 
    // from data base
    private static final class AddressMapper implements RowMapper<Address> {

        @Override
        public Address mapRow(ResultSet rs, int i) throws SQLException {
            Address address = new Address();
            address.setAddressId(rs.getInt("addressID"));
            address.setFirstName(rs.getString("firstName"));
            address.setLastName(rs.getString("lastName"));
            address.setAddress(rs.getString("address"));
            address.setCity(rs.getString("city"));
            address.setState(rs.getString("state"));
            address.setZipCode(rs.getString("zip"));

            return address;
        }

    }

}
