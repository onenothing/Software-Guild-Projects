/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.sitemapwebappmvc.controller;

import com.tsg.sitemapwebappmvc.calcs.InterestCalc;
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
public class InterestCalcController {

    @RequestMapping(value = "/InterestCalcController", method = RequestMethod.GET)
    public String displayTipForm(HttpServletRequest req, Model model) {
        return "interestcalc";

    }
    
     @RequestMapping(value = "/InterestCalcController", method = RequestMethod.POST)
    public String getInterestCalcResults(HttpServletRequest request, Model model) {
        
         String newAPR = request.getParameter("percentageToCalc");
        Double apr = Double.parseDouble(newAPR);
        String newPrincipal = request.getParameter("intitialPrincipal");
        Double principal = Double.parseDouble(newPrincipal);
        String investLength = request.getParameter("periodToInvest");
        int year = Integer.parseInt(investLength);
        String compoundType = request.getParameter("typeOfCompounding");
        InterestCalc.TypeOfCompounding type = InterestCalc.TypeOfCompounding.fromAbbrv(compoundType);

        InterestCalc calc = new InterestCalc(apr, principal, year, type);
        
        request.setAttribute("interestYearsCalcs", calc.getYearlyInterestCalculations());
        request.setAttribute("interestCalcError", calc.getError());
        
        return "icresponse";
    }
}
