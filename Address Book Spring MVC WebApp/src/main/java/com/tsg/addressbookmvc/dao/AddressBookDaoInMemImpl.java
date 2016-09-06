/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.addressbookmvc.dao;

import com.tsg.addressbookmvc.dto.Address;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
//1. We use a HashMap to hold our Addresses so we can enforce the uniqueness of the address id.
//2. We use Java 8 aggregate operations, lambdas, and predicates to search the HashMap values.
public class AddressBookDaoInMemImpl implements AddressBookDAO {

    // holds all of our Address objects - simulates the database
    private Map<Integer, Address> AddressMap = new HashMap<>();
    // used to assign ids to Addresses - simulates the auto increment
    // primary key for Addresses in a database
    private static int addressIdCounter = 0;

    @Override
    public Address addAddress(Address address) {
        // assign the current counter values as the addressid
        address.setAddressId(addressIdCounter);
        // increment the counter so it is ready for use for the next address
        addressIdCounter++;
        AddressMap.put(address.getAddressId(), address);
        return address;
    }

    @Override
    public void removeAddress(int addressId) {
        AddressMap.remove(addressId);
    }

    @Override
    public void updateAddress(Address address) {
        AddressMap.put(address.getAddressId(), address);
    }

    @Override
    public List<Address> getAllAddresses() {
        Collection<Address> c = AddressMap.values();
        return new ArrayList(c);
    }

    @Override
    public Address getAddressById(int addressId) {
        return AddressMap.get(addressId);
    }

    @Override
    public List<Address> searchAddress(Map<SearchTerm, String> criteria) {
        
        //Add string criteria with enum key SearchTerm
        String firstNameCriteria = criteria.get(SearchTerm.FIRSTNAME);
        String lastNameCriteria = criteria.get(SearchTerm.LASTNAME);
        String addressCriteria = criteria.get(SearchTerm.ADDRESS);
        String cityCriteria = criteria.get(SearchTerm.CITY);
        String stateCriteria = criteria.get(SearchTerm.STATE);
        String zipCodeCriteria = criteria.get(SearchTerm.ZIP);

        // Declare all the predicate conditions
        Predicate<Address> firstNameMatches;
        Predicate<Address> lastNameMatches;
        Predicate<Address> addressMatches;
        Predicate<Address> cityMatches;
        Predicate<Address> stateMatches;
        Predicate<Address> zipCodeMatches;

        // Placeholder predicate - always returns true. Used for search terms
        // that are empty
        Predicate<Address> truePredicate = (c) -> {
            return true;
        };

        // Assign values to predicates. If a given search term is empty, just
        // assign the default truePredicate, otherwise assign the predicate that
        // properly filters for the given term
        firstNameMatches = (firstNameCriteria == null || firstNameCriteria.isEmpty()) ? truePredicate : (c) -> c.getFirstName().contains(firstNameCriteria);
        lastNameMatches = (lastNameCriteria == null || lastNameCriteria.isEmpty()) ? truePredicate : (c) -> c.getLastName().contains(lastNameCriteria);
        addressMatches = (addressCriteria == null || addressCriteria.isEmpty()) ? truePredicate : (c) -> c.getAddress().contains(addressCriteria);
        cityMatches = (cityCriteria == null || cityCriteria.isEmpty()) ? truePredicate : (c) -> c.getCity().contains(cityCriteria);
        stateMatches = (stateCriteria == null || stateCriteria.isEmpty()) ? truePredicate : (c) -> c.getState().contains(stateCriteria);
        zipCodeMatches = (zipCodeCriteria == null || zipCodeCriteria.isEmpty()) ? truePredicate : (c) -> c.getZipCode().contains(zipCodeCriteria);

        // Return the list of Addresses that match the given criteria. To do this we
        // just (.AND) all the predicates together in a filter operation.
        return AddressMap.values().stream()
                .filter(firstNameMatches
                        .and(lastNameMatches)
                        .and(addressMatches)
                        .and(cityMatches)
                        .and(stateMatches)
                        .and(zipCodeMatches))
                .collect(Collectors.toList());
    }
}
