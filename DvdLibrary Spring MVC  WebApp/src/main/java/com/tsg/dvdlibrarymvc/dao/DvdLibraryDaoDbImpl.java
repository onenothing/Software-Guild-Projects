/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.dvdlibrarymvc.dao;

import com.tsg.dvdlibrarymvc.dto.DVD;
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
public class DvdLibraryDaoDbImpl implements DvdLibraryDAO {
    
     private static final String SQL_INSERT_DVD
            = "insert into dvds (dvdTitle, directorsName, mpaaRating, studio, releaseDate) value (?,?,?,?,?)";

    private static final String SQL_DELETE_DVD
            = "delete from dvds where dvdID = ?";

    private static final String SQL_UPDATE_DVD
            = "update dvds set dvdTitle = ?, directorsName = ?, mpaaRating = ?, studio = ?, releaseDate = ? where dvdID = ?";
    
    private static final String SQL_SELECT_ALL_DVDS= "select * from dvds";
    
    private static final String SQL_SELECT_DVD = "select * from dvds where dvdID = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public DVD addDVD(DVD dvd) {
        jdbcTemplate.update(SQL_INSERT_DVD,
                dvd.getDvdTitle(),
                dvd.getDirectorsName(),
                dvd.getMpaaRating(),
                dvd.getStudio(),
                dvd.getReleaseDate());
        dvd.setDvdId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return dvd;
    }

    @Override
    public void removeDVD(int dvdId) {
        jdbcTemplate.update(SQL_DELETE_DVD, dvdId);
    }

    @Override
    public void updateDVD(DVD dvd) {
        jdbcTemplate.update(SQL_UPDATE_DVD,
                dvd.getDvdTitle(),
                dvd.getDirectorsName(),
                dvd.getMpaaRating(),
                dvd.getStudio(),
                dvd.getReleaseDate(),
                dvd.getDvdId());
    }

    @Override
    public List<DVD> getAllDVDs() {
        return jdbcTemplate.query(SQL_SELECT_ALL_DVDS, new DvdMapper());
    }

    @Override
    public DVD getDVDById(int dvdId) {
        try {
        return jdbcTemplate.queryForObject(SQL_SELECT_DVD, new DvdMapper(), dvdId);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<DVD> searchDvd(Map<SearchTerm, String> criteria) {
        if (criteria.size() == 0) {
            return getAllDVDs();
        }else {
            StringBuilder sQuery = new StringBuilder("select * from dvds where ");
            int numParams = criteria.size();
            int paramPosition = 0;
            String[] paramVals = new String [numParams];
            Set<SearchTerm> keyset = criteria.keySet();
            Iterator<SearchTerm> iter = keyset.iterator();
            
            while(iter.hasNext()) {
                SearchTerm currentKey = iter.next();
                
                if (paramPosition > 0){
                    sQuery.append(" and ");
                }
                
                sQuery.append(currentKey);
                sQuery.append(" = ? ");
                
                paramVals[paramPosition] = criteria.get(currentKey);
                paramPosition++;
                
            }
            return jdbcTemplate.query(sQuery.toString(), new DvdMapper(), paramVals);
        }
        
    }

    private static final class DvdMapper implements RowMapper<DVD> {

        @Override
        public DVD mapRow(ResultSet rs, int i) throws SQLException {
            DVD dvd = new DVD();
            dvd.setDvdId(rs.getInt("dvdID"));
            dvd.setDvdTitle(rs.getString("dvdTitle"));
            dvd.setDirectorsName(rs.getString("directorsName"));
            dvd.setMpaaRating(rs.getString("mpaaRating"));
            dvd.setStudio(rs.getString("studio"));
            dvd.setReleaseDate(rs.getString("releaseDate"));
            
            
            return dvd;
        }

    }
    
}
