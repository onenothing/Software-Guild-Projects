/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.dvdlibrarymvc.dao;

import com.tsg.dvdlibrarymvc.dto.DVD;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
public interface DvdLibraryDAO {
    
    public DVD addDVD(DVD dvd);
    public void removeDVD(int dvdId);
    public void updateDVD(DVD dvd);
    public List<DVD>getAllDVDs();
    public DVD getDVDById(int dvdId);
    public List<DVD> searchDvd(Map<SearchTerm,String> criteria);
    
}
