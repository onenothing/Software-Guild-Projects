/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.addressbookmvc;

import com.tsg.addressbookmvc.dao.AddressBookDAO;
import com.tsg.addressbookmvc.dao.SearchTerm;
import com.tsg.addressbookmvc.dto.Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
@Controller
public class SearchController {

    private final AddressBookDAO dao;

    @Inject
    public SearchController(AddressBookDAO dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String displaySearchPage() {
        return "search";
    }
    // This method will be invoked by Spring MVC when it sees a POST request for
    // AddressBookMVC/search/addresses. It translates the entered search terms
    // from the given Map<String, String> to a Map<SearchTerm, String>, passes
    // the search criteria to the DAO, and returns the search results to the
    // caller.
    @RequestMapping(value = "search/addresses", method = RequestMethod.POST)
    @ResponseBody
    public List<Address> searchAddress(@RequestBody Map<String, String> searchMap) {
        // Create the map of search criteria to send to the DAO
        Map<SearchTerm, String> criteriaMap = new HashMap<>();
        // Determine which search terms have values, translate the String
        // keys into SearchTerm enums, and set the corresponding values
        // appropriately.
        String currentTerm = searchMap.get("firstName");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.FIRSTNAME, currentTerm);
        }
        currentTerm = searchMap.get("lastName");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.LASTNAME, currentTerm);
        }
        currentTerm = searchMap.get("address");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.ADDRESS, currentTerm);
        }
        currentTerm = searchMap.get("city");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.CITY, currentTerm);
        }
        currentTerm = searchMap.get("state");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.STATE, currentTerm);
        }
        currentTerm = searchMap.get("zipCode");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.ZIP, currentTerm);
        }
        return dao.searchAddress(criteriaMap);
    }

}
