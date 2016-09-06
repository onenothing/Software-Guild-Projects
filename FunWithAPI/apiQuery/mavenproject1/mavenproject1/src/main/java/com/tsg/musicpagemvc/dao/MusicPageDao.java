/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.musicpagemvc.dao;

import com.tsg.musicpage.dto.Band;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
public interface MusicPageDao {
    
    public Band addBand(Band band);
    public void removeBand(int bandId);
    public void updateBand(Band band);
    public List<Band>getAllBands();
    public Band getBandById(int bandId);
    public List<Band> searchBands(Map<SearchTerm,String> criteria);
    
}
