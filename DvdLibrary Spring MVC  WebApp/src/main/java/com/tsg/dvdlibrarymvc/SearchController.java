/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.dvdlibrarymvc;

import com.tsg.dvdlibrarymvc.dao.DvdLibraryDAO;
import com.tsg.dvdlibrarymvc.dao.SearchTerm;
import com.tsg.dvdlibrarymvc.dto.DVD;
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

    private final DvdLibraryDAO dao;
    
    @Inject
    public SearchController(DvdLibraryDAO dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String displaySearchPage() {
        return "search";
    }

    // This method will be invoked by Spring MVC when it sees a POST request for
    // DvdLibraryMVC/search/dvds. It translates the entered search terms
    // from the given Map<String, String> to a Map<SearchTerm, String>, passes
    // the search criteria to the DAO, and returns the search results to the
    // caller.
    @RequestMapping(value = "search/dvds", method = RequestMethod.POST)
    @ResponseBody
    public List<DVD> searchDvd(@RequestBody Map<String, String> searchMap) {
        // Create the map of search criteria to send to the DAO
        Map<SearchTerm, String> criteriaMap = new HashMap<>();
        // Determine which search terms have values, translate the String
        // keys into SearchTerm enums, and set the corresponding values
        // appropriately.
        String currentTerm = searchMap.get("dvdTitle");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.DVDTITLE, currentTerm);
        }
        currentTerm = searchMap.get("directorsName");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.DIRECTORSNAME, currentTerm);
        }
        currentTerm = searchMap.get("mpaaRating");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.MPAARATING, currentTerm);
        }
        currentTerm = searchMap.get("studio");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.STUDIO, currentTerm);
        }
        currentTerm = searchMap.get("releaseDate");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.RELEASEDATE, currentTerm);
        }

        return dao.searchDvd(criteriaMap);
    }

}
