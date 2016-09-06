/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.dvdlibrarymvc.dao;

import com.tsg.dvdlibrarymvc.dto.DVD;
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
public class DvdLibraryDaoInMemImpl implements DvdLibraryDAO {

    private Map<Integer, DVD> discMap = new HashMap<>();
    private static int dvdIdCounter = 0;

    @Override
    public DVD addDVD(DVD dvd) {
        dvd.setDvdId(dvdIdCounter);
        dvdIdCounter++;
        discMap.put(dvd.getDvdId(), dvd);
        return dvd;
    }

    @Override
    public void removeDVD(int DVDId) {
        discMap.remove(DVDId);
    }

    @Override
    public void updateDVD(DVD dvd) {
        discMap.put(dvd.getDvdId(), dvd);
    }

    @Override
    public List<DVD> getAllDVDs() {
        Collection<DVD> cd = discMap.values();
        return new ArrayList(cd);
    }

    @Override
    public DVD getDVDById(int DVDId) {
        return discMap.get(DVDId);
    }

    @Override
    public List<DVD> searchDvd(Map<SearchTerm, String> criteria) {
        
        String dvdTitleCriteria = criteria.get(SearchTerm.DVDID);
        String directorsNameCriteria = criteria.get(SearchTerm.DIRECTORSNAME);
        String mpaaRatingCriteria = criteria.get(SearchTerm.MPAARATING);
        String studioCriteria = criteria.get(SearchTerm.STUDIO);
        String releaseDateCriteria = criteria.get(SearchTerm.RELEASEDATE);

        Predicate<DVD> dvdTitleMatches;
        Predicate<DVD> directorsNameMatches;
        Predicate<DVD> mpaaRatingMatches;
        Predicate<DVD> studioMatches;
        Predicate<DVD> releaseDateMatches;

        Predicate<DVD> truePredicate = (c) -> {
            return true;
        };

        dvdTitleMatches = (dvdTitleCriteria == null || dvdTitleCriteria.isEmpty()) ? truePredicate : (c) -> c.getDvdTitle().contains(dvdTitleCriteria);
        directorsNameMatches = (directorsNameCriteria == null || directorsNameCriteria.isEmpty()) ? truePredicate : (c) -> c.getDirectorsName().contains(directorsNameCriteria);
        mpaaRatingMatches = (mpaaRatingCriteria == null || mpaaRatingCriteria.isEmpty()) ? truePredicate : (c) -> c.getMpaaRating().contains(mpaaRatingCriteria);
        studioMatches = (studioCriteria == null || studioCriteria.isEmpty()) ? truePredicate : (c) -> c.getStudio().contains(studioCriteria);
        releaseDateMatches = (releaseDateCriteria == null || releaseDateCriteria.isEmpty()) ? truePredicate : (c) -> c.getReleaseDate().contains(releaseDateCriteria);

        return discMap.values().stream()
                .filter(dvdTitleMatches
                        .and(directorsNameMatches)
                        .and(mpaaRatingMatches)
                        .and(studioMatches)
                        .and(releaseDateMatches))
                .collect(Collectors.toList());
    }
}
