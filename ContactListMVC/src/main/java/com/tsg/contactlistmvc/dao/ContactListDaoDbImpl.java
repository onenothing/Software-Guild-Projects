/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.contactlistmvc.dao;

import com.tsg.contactlistmvc.dto.Contact;
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
public class ContactListDaoDbImpl implements ContactListDAO {

    private static final String SQL_INSERT_CONTACT
            = "insert into contacts (firstName, lastName, company, phone, email) value (?,?,?,?,?)";

    private static final String SQL_DELETE_CONTACT
            = "delete from contacts where contactID = ?";

    private static final String SQL_UPDATE_CONTACT
            = "update contacts set firstName = ?, lastName = ?, company = ?, phone = ?, email = ? where contactID = ?";

    private static final String SQL_SELECT_ALL_CONTACTS = "select * from contacts";

    private static final String SQL_SELECT_CONTACT = "select * from contacts where contactID = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Contact addContact(Contact contact) {
        jdbcTemplate.update(SQL_INSERT_CONTACT,
                contact.getFirstName(),
                contact.getLastName(),
                contact.getCompany(),
                contact.getPhone(),
                contact.getEmail());
        contact.setContactId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return contact;
    }

    @Override
    public void removeContact(int contactId) {
        jdbcTemplate.update(SQL_DELETE_CONTACT, contactId);
    }

    @Override
    public void updateContact(Contact contact) {
        jdbcTemplate.update(SQL_UPDATE_CONTACT,
                contact.getFirstName(),
                contact.getLastName(),
                contact.getCompany(),
                contact.getPhone(),
                contact.getEmail(),
                contact.getContactId());
    }

    @Override
    public List<Contact> getAllContacts() {
        return jdbcTemplate.query(SQL_SELECT_ALL_CONTACTS, new ContactMapper());
    }

    @Override
    public Contact getContactById(int contactId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_CONTACT, new ContactMapper(), contactId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Contact> searchContacts(Map<SearchTerm, String> criteria) {
        if (criteria.size() == 0) {
            return getAllContacts();
        } else {
            StringBuilder sQuery = new StringBuilder("select * from contacts where ");
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
                //adding new functionality to search partial values must use % symbol
                sQuery.append(currentKey);
                sQuery.append(" " + currentKey.getSearchOperator() + " ? ");

                paramVals[paramPosition] = criteria.get(currentKey);
                paramPosition++;

            }
            return jdbcTemplate.query(sQuery.toString(), new ContactMapper(), paramVals);
        }

    }

    private static final class ContactMapper implements RowMapper<Contact> {

        @Override
        public Contact mapRow(ResultSet rs, int i) throws SQLException {
            Contact contact = new Contact();
            contact.setContactId(rs.getInt("contactID"));
            contact.setFirstName(rs.getString("firstName"));
            contact.setLastName(rs.getString("lastName"));
            contact.setCompany(rs.getString("company"));
            contact.setPhone(rs.getString("phone"));
            contact.setEmail(rs.getString("email"));

            return contact;
        }

    }

}
