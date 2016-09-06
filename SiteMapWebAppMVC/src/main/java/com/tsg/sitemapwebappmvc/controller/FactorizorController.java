/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.sitemapwebappmvc.controller;

import com.tsg.sitemapwebappmvc.calcs.Factors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
@Controller
public class FactorizorController {

    @RequestMapping(value = "/FactorizorController", method = RequestMethod.GET)
    public String displayFactors(HttpServletRequest req, Model model) {
        return "factorizor";

    }
    @RequestMapping(value = "/FactorizorController", method = RequestMethod.POST)
    public String getFactorResults(HttpServletRequest request, Model model) {
        
          
        Factors factorize = new Factors( Integer.parseInt(request.getParameter("numberToFactor")) );
        request.setAttribute( "factors", factorize.getFactors() );
        request.setAttribute("perfect", factorize.isPerfect());
        request.setAttribute("prime", factorize.isPrime());
        
        return "factresponse";
    }
}
