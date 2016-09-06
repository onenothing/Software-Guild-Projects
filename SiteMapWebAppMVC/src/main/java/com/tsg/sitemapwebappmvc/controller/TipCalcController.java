/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.sitemapwebappmvc.controller;

import com.tsg.sitemapwebappmvc.calcs.TipCalculator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * /**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
@Controller
public class TipCalcController {

    @RequestMapping(value = "/TipCalcController", method = RequestMethod.GET)
    public String displayTipForm(HttpServletRequest req, Model model) {
        return "tipcalc";

    }

    @RequestMapping(value = "/TipCalcController", method = RequestMethod.POST)
    public String getTipCalcResults(HttpServletRequest request, Model model) {

        String serviceCost = request.getParameter("costOfService");
        double cost = Double.parseDouble(serviceCost);

        String tipPercentage = request.getParameter("tipPercent");
        double tips = Double.parseDouble(tipPercentage);

        TipCalculator tipper = new TipCalculator(cost, tips);
        double tipNow = tipper.CalculateTip();

        request.setAttribute("tip", tipNow);

        return "tipcalcresponse";
    }

}
