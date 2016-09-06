/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.addressbookmvc.dao;

import com.tsg.addressbookmvc.dto.Address;
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
public class AddressBookDaoTest {

    private AddressBookDAO dao;
    private Address ad1;
    private Address ad2;
    private Address ad3;

    public AddressBookDaoTest() {
    }

    @Before
    public void setUp() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("addressBookDAO", AddressBookDAO.class);

        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from addresses");

        ad1 = new Address();
        ad1.setFirstName("Walt");
        ad1.setLastName("Brown");
        ad1.setAddress("1234 Dock St.");
        ad1.setCity("Akron");
        ad1.setState("Ohio");
        ad1.setZipCode("43221");

        ad2 = new Address();
        ad2.setFirstName("Mike");
        ad2.setLastName("Jones");
        ad2.setAddress("45 W 12th ave.");
        ad2.setCity("Stringtown");
        ad2.setState("Georgia");
        ad2.setZipCode("98637");

        // Create new address - same last name as first address but different
        // address
        ad3 = new Address();
        ad3.setFirstName("Ricky");
        ad3.setLastName("Brown");
        ad3.setAddress("3451 Roswell Dr.");
        ad3.setCity("Columbus");
        ad3.setState("Ohio");
        ad3.setZipCode("43227");
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
//    @Test
//    public void addGetDeleteAddress() {
//        dao.addAddress(ad1);
//        Address fromDb = dao.getAddressById(ad1.getAddressId());
//        assertEquals(fromDb, ad1);
//        dao.removeAddress(ad1.getAddressId());
//        assertNull(dao.getAddressById(ad1.getAddressId()));
//    }
//
//    @Test
//    public void addUpdateAddress() {
//
//        dao.addAddress(ad1);
//
//        ad1.setZipCode("43221");
//        dao.updateAddress(ad1);
//        Address fromDb = dao.getAddressById(ad1.getAddressId());
//        assertEquals(ad1, fromDb);
//
//    }
//
//    @Test
//    public void getAllAddresses() {
//        dao.addAddress(ad1);
//        dao.addAddress(ad2);
//
//        List<Address> adBook = dao.getAllAddresses();
//        assertEquals(2, adBook.size());
//    }
//
//    @Test
//    public void searchAddress() {
//        dao.addAddress(ad1);
//        dao.addAddress(ad2);
//        dao.addAddress(ad3);
//        
//        // Create search criteria
//        Map<SearchTerm, String> books = new HashMap<>();
//        
//        books.put(SearchTerm.LASTNAME, "Jones");
//        List<Address> adBook = dao.searchAddress(books);
//        assertEquals(1, adBook.size());
//        assertEquals(ad2, adBook.get(0));
//        // New search criteria - look for Brown
//        books = new HashMap<>();
//        books.put(SearchTerm.LASTNAME, "Brown");
//        adBook = dao.searchAddress(books);
//        assertEquals(2, adBook.size());
//        // Checking for firstName "Walt"
//        books = new HashMap<>();
//        books.put(SearchTerm.FIRSTNAME, "Walt");
//        adBook = dao.searchAddress(books);
//        assertEquals(1, adBook.size());
//
//        books = new HashMap<>();
//        books.put(SearchTerm.ADDRESS, "1234 Dock St.");
//        adBook = dao.searchAddress(books);
//        assertEquals(1, adBook.size());
//        assertEquals(ad1, adBook.get(0));
//
//        books = new HashMap<>();
//        books.put(SearchTerm.ADDRESS, "3451 Roswell Dr.");
//        adBook = dao.searchAddress(books);
//        assertEquals(1, adBook.size());
//        assertEquals(ad3, adBook.get(0));
//
//        books = new HashMap<>();
//        books.put(SearchTerm.ADDRESS, "45 W 12th ave.");
//        adBook = dao.searchAddress(books);
//        assertEquals(1, adBook.size());
//        // Change address to Columbus, should get back ad3
//        books = new HashMap<>();
//        books.put(SearchTerm.CITY, "Columbus");
//        adBook = dao.searchAddress(books);
//        assertEquals(1, adBook.size());
//        assertEquals(ad3, adBook.get(0));
//
//        books = new HashMap<>();
//        books.put(SearchTerm.LASTNAME, "Brown");
//        books.put(SearchTerm.FIRSTNAME, "Walt");
//        adBook = dao.searchAddress(books);
//        assertEquals(1, adBook.size());
//        assertEquals(ad1, adBook.get(0));
//
//    }

}
