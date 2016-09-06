/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.dvdlibrarymvc;

import com.tsg.dvdlibrarymvc.dao.DvdLibraryDAO;
import com.tsg.dvdlibrarymvc.dto.DVD;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
@Controller
public class RESTController {

    private final DvdLibraryDAO dao;

    @Inject
    public RESTController(DvdLibraryDAO dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.GET)
    @ResponseBody

    public DVD getDvd(@PathVariable("id") int id) {
        return dao.getDVDById(id);
    }

    @RequestMapping(value = "/dvd", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public DVD createDvd(@Valid @RequestBody DVD dvd) {
        return dao.addDVD(dvd);

    }

    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDvd(@PathVariable("id") int id) {
        dao.removeDVD(id);

    }

    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDvd(@PathVariable("id") int id, @Valid @RequestBody DVD dvd) {
        dvd.setDvdId(id);
        dao.updateDVD(dvd);

    }

    @RequestMapping(value = "/dvds", method = RequestMethod.GET)
    @ResponseBody
    public List<DVD> getAllDVDs() {
        return dao.getAllDVDs();

    }
}
