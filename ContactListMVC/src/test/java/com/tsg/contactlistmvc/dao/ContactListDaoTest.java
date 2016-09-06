/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.contactlistmvc.dao;

import com.tsg.contactlistmvc.dto.Contact;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class ContactListDaoTest {

    private ContactListDAO dao;
    private Contact nc1;
    private Contact nc2;
    private Contact nc3;

    public ContactListDaoTest() {
    }

    @Before
    public void setUp() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("contactListDAO", ContactListDAO.class);

        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from contacts");

        nc1 = new Contact();
        nc1.setFirstName("Jimmy");
        nc1.setLastName("Smith");
        nc1.setCompany("Sun");
        nc1.setEmail("jimmy@smith.com");
        nc1.setPhone("1112223333");

        nc2 = new Contact();
        nc2.setFirstName("John");
        nc2.setLastName("Jones");
        nc2.setCompany("Apple");
        nc2.setEmail("john@jones.com");
        nc2.setPhone("5556667777");

        nc3 = new Contact();
        nc3.setFirstName("Steve");
        nc3.setLastName("Smith");
        nc3.setCompany("Microsoft");
        nc3.setEmail("steve@msft.com");
        nc3.setPhone("5552221234");

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void addGetDeleteContact() {

        dao.addContact(nc1);
        Contact fromDb = dao.getContactById(nc1.getContactId());
        assertEquals(fromDb, nc1);
        dao.removeContact(nc1.getContactId());
        assertNull(dao.getContactById(nc1.getContactId()));

    }

    @Test
    public void addUpdateContact() {

        dao.addContact(nc1);
        nc1.setPhone("9999999999");

        dao.updateContact(nc1);

        Contact fromDb = dao.getContactById(nc1.getContactId());
        assertEquals(nc1, fromDb);

    }

    @Test
    public void getAllContacts() {

        dao.addContact(nc1);
        dao.addContact(nc2);
        dao.addContact(nc3);

        List<Contact> cList = dao.getAllContacts();
        assertEquals(3, cList.size());

    }

    @Test
    public void searchContacts() {

        dao.addContact(nc1);
        dao.addContact(nc2);
        dao.addContact(nc3);

        Map<SearchTerm, String> criteria = new HashMap<>();

        criteria.put(SearchTerm.LASTNAME, "Jones");
        List<Contact> cList = dao.searchContacts(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc2, cList.get(0));

        criteria.put(SearchTerm.LASTNAME, "Smith");
        cList = dao.searchContacts(criteria);
        assertEquals(2, cList.size());

        criteria.put(SearchTerm.COMPANY, "Sun");
        cList = dao.searchContacts(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc1, cList.get(0));

        criteria.put(SearchTerm.COMPANY, "Microsoft");
        cList = dao.searchContacts(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc3, cList.get(0));

        criteria = new HashMap<>();
        criteria.put(SearchTerm.EMAIL, "john@jones.com");
        cList = dao.searchContacts(criteria);
        assertEquals(1, cList.size());
        assertEquals(nc2, cList.get(0));

    }
}
