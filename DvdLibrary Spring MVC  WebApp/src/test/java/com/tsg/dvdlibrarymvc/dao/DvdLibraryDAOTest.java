/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.dvdlibrarymvc.dao;

import com.tsg.dvdlibrarymvc.dto.DVD;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
public class DvdLibraryDAOTest {

    private DvdLibraryDAO dao;
    private DVD dvd1;
    private DVD dvd2;
    private DVD dvd3;

    public DvdLibraryDAOTest() {
    }

    @Before
    public void setUp() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("dvdLibraryDAO", DvdLibraryDAO.class);

        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from dvds");

        dvd1 = new DVD();
        dvd1.setDvdTitle("Fargo");
        dvd1.setDirectorsName("Joel Cohen");
        dvd1.setMpaaRating("R");
        dvd1.setStudio("Miramax");
        dvd1.setReleaseDate("1996");

        dvd2 = new DVD();
        dvd2.setDvdTitle("Raising Arizona");
        dvd2.setDirectorsName("Ethan Cohen");
        dvd2.setMpaaRating("R");
        dvd2.setStudio("STUDIO");
        dvd2.setReleaseDate("1989");

        dvd3 = new DVD();
        dvd3.setDvdTitle("O brother, where art thou");
        dvd3.setDirectorsName("Joel Cohen");
        dvd3.setMpaaRating("pg-13");
        dvd3.setStudio("Universal");
        dvd3.setReleaseDate("2000");

    }

    @After
    public void tearDown() {
    }

//     TODO add test methods here.
//     The methods must be annotated with annotation @Test. For example:
//     @Test
//     public void hello() {}
//    @Test
//    public void addGetDeleteDvd() {
//        dao.addDVD(dvd1);
//        DVD fromDb = dao.getDVDById(dvd1.getDvdId());
//        assertEquals(fromDb, dvd1);
//        dao.removeDVD(dvd1.getDvdId());
//        assertNull(dao.getDVDById(dvd1.getDvdId()));
//    }

//    @Test
//    public void addUpdateDvd() {
//
//        dao.addDVD(dvd1);
//
//        //21dvd1.getReleaseDate("1996");
//        dao.updateDVD(dvd1);
//        DVD fromDb = dao.getDVDById(dvd1.getDvdId());
//        assertEquals(dvd1, fromDb);
//
//    }

//    @Test
//    public void getAllDvds() {
//        dao.addDVD(dvd1);
//        dao.addDVD(dvd2);
//
//        List<DVD> discList = dao.getAllDVDs();
//        assertEquals(2, discList.size());
//    }
//
//    @Test
//    public void searchDvd() {
//        dao.addDVD(dvd1);
//        dao.addDVD(dvd2);
//        dao.addDVD(dvd3);
//
//        Map<SearchTerm, String> discs = new HashMap<>();
//
//        discs.put(SearchTerm.DVD_TITLE, "Raising Arizona");
//        List<DVD> discList = dao.searchDvd(discs);
//        assertEquals(1, discList.size());
//        assertEquals(dvd2, discList.get(0));
//
//        discs.put(SearchTerm.DIRECTORS_NAME, "Joel Cohen");
//        discList = dao.searchDvd(discs);
//        assertEquals(2, discList.size());
//
//        discs.put(SearchTerm.DVD_TITLE, "Fargo");
//        discList = dao.searchDvd(discs);
//        assertEquals(1, discList.size());
//
//        discs.put(SearchTerm.MPAA_RATING, "R");
//        discList = dao.searchDvd(discs);
//        assertEquals(1, discList.size());
//        assertEquals(dvd1, discList.get(0));
//
//        discs.put(SearchTerm.STUDIO, "Universal");
//        discList = dao.searchDvd(discs);
//        assertEquals(1, discList.size());
//        assertEquals(dvd3, discList.get(0));
//
//        discs.put(SearchTerm.STUDIO, "STUDIO");
//        discList = dao.searchDvd(discs);
//        assertEquals(2, discList.size());
//
//        discs.put(SearchTerm.RELEASE_DATE, "2000");
//        discList = dao.searchDvd(discs);
//        assertEquals(1, discList.size());
//        assertEquals(dvd3, discList.get(0));
//
//    }
}
