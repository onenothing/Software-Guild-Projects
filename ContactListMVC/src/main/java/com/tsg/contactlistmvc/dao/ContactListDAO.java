/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.contactlistmvc.dao;

import com.tsg.contactlistmvc.dto.Contact;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
public interface ContactListDAO {
    
    public Contact addContact(Contact contact);
    public void removeContact(int contactId);
    public void updateContact(Contact contact);
    public List<Contact>getAllContacts();
    public Contact getContactById(int contactId);
    public List<Contact> searchContacts(Map<SearchTerm,String> criteria);
    
}
