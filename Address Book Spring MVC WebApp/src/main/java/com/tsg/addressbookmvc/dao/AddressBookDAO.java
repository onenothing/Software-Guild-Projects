/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.addressbookmvc.dao;

import com.tsg.addressbookmvc.dto.Address;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
public interface AddressBookDAO {
    
    // add the given Address to the data store
    public Address addAddress(Address address);
    // remove the Address with the given id from the data store
    public void removeAddress(int addressId);
    // update the given Address in the data store
    public void updateAddress(Address address);
    // retrieve all Addresses from the data store
    public List<Address>getAllAddresses();
    // retrieve the Address with the given id from the data store 
    public Address getAddressById(int addressId);
    // search for Addresses by the given search criteria values 
    public List<Address> searchAddress(Map<SearchTerm,String> criteria);
    
}
