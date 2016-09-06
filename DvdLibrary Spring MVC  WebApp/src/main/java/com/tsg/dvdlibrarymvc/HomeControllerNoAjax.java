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
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
@Controller
public class HomeControllerNoAjax {

    private final DvdLibraryDAO dao;

    @Inject
    public HomeControllerNoAjax(DvdLibraryDAO dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/displayDVDListNoAjax", method = RequestMethod.GET)
    public String displayDVDListNoAjax(Model model) {
        List<DVD> movieList = dao.getAllDVDs();
        model.addAttribute("dvdLibrary", movieList);

        return "displayDVDListNoAjax";
    }

    @RequestMapping(value = "displayNewDVDFormNoAjax", method = RequestMethod.GET)
    public String displayNewDVDFormNoAjax(Model model) {
        
        DVD dvd = new DVD();
        model.addAttribute("dvd", dvd);
        return "newDVDFormNoAjax";
    }

    @RequestMapping(value = "/addNewDVDFormNoAjax", method = RequestMethod.POST)
    public String addNewDVDNoAjax(@Valid @ModelAttribute("dvd")DVD dvd,
             BindingResult result) {
        if(result.hasErrors()) {
            return "newDVDFormNoAjax";
        }
        
//        String dvdTitle = req.getParameter("dvdTitle");
//        String directorsName = req.getParameter("directorsName");
//        String mpaaRating = req.getParameter("mpaaRating");
//        String studio = req.getParameter("studio");
//        String releaseDate = req.getParameter("releaseDate");
//
//        DVD disc1 = new DVD();
//        disc1.setDvdTitle(dvdTitle);
//        disc1.setDirectorsName(directorsName);
//        disc1.setMpaaRating(mpaaRating);
//        disc1.setStudio(studio);
//        disc1.setReleaseDate(releaseDate);

        dao.addDVD(dvd);

        return "redirect:displayDVDListNoAjax";

    }

    @RequestMapping(value = "/deleteDVDNoAjax", method = RequestMethod.GET)
    public String deleteDVDNoAjax(HttpServletRequest req) {

        int dvdId = Integer.parseInt(req.getParameter("dvdId"));

        dao.removeDVD(dvdId);
        return "redirect:displayDVDListNoAjax";
    }

    @RequestMapping(value = "/displayEditDVDFormNoAjax", method = RequestMethod.GET)
    public String displayEditDVDFormNoAjax(HttpServletRequest req, Model model) {

        int dvdId = Integer.parseInt(req.getParameter("dvdId"));
        
        DVD dvd = dao.getDVDById(dvdId);
        
        model.addAttribute("dvd", dvd);
        
        return "editDVDFormNoAjax";
    }
    
    @RequestMapping(value = "/editDVDNoAjax", method = RequestMethod.POST)
    
     public String EditDVDNoAjax(@Valid @ModelAttribute("dvd")DVD dvd,
             BindingResult result) {
         if (result.hasErrors()) {
             return "editDVDFormNoAjax";
         }
         
         
         dao.updateDVD(dvd);
         return "redirect:displayDVDListNoAjax";
     }
}
