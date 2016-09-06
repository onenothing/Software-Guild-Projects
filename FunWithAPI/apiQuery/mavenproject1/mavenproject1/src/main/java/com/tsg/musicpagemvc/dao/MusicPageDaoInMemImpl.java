/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.musicpagemvc.dao;

import com.tsg.musicpage.dto.Band;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
public class MusicPageDaoInMemImpl implements MusicPageDao {
    
    private Map<Integer, Band> rockMap = new HashMap<>();
    private static int bandIdCounter = 0;

    @Override
    public Band addBand(Band band) {
        band.setBandId(bandIdCounter);
        bandIdCounter++;
        rockMap.put(band.getBandId(), band);
        return band;
    }

    @Override
    public void removeBand(int bandId) {
        rockMap.remove(bandId);
    }

    @Override
    public void updateBand(Band band) {
        rockMap.put(band.getBandId(), band);
    }

    @Override
    public List<Band> getAllBands() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Band getBandById(int bandId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Band> searchBands(Map<SearchTerm, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
