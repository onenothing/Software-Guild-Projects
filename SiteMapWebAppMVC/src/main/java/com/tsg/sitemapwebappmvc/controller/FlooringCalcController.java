/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.sitemapwebappmvc.controller;

import com.tsg.sitemapwebappmvc.calcs.FlooringCalculator;
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
public class FlooringCalcController {

    @RequestMapping(value = "/FlooringCalcController", method = RequestMethod.GET)
    public String displayFlooringForm(HttpServletRequest request, Model model) {

        return "flooringcalc";

    }

    @RequestMapping(value = "/FlooringCalcController", method = RequestMethod.POST)
    public String getFlooringCalcResults(HttpServletRequest request, Model model) {

        String newWidth = request.getParameter("width");
        Double width = Double.parseDouble(newWidth);
        String newLength = request.getParameter("length");
        Double length = Double.parseDouble(newLength);
        String newCost = request.getParameter("costSqFt");
        Double costPerSqFt = Double.parseDouble(newCost);

        FlooringCalculator floorCalc = new FlooringCalculator(width, length, costPerSqFt);

        double newArea = floorCalc.getArea(width, length);
        double newMatCost = floorCalc.getMateialCost(newArea, costPerSqFt);
        double newLaborCost = floorCalc.getLaborRate();
        double newTotal = floorCalc.getOrderTotal(newLaborCost, newMatCost);
        double totalTime = newArea / 20;

        request.setAttribute("newMatCost", newMatCost);
        request.setAttribute("newLaborCost", newLaborCost);
        request.setAttribute("newArea", newArea);
        request.setAttribute("newTotal", newTotal);
        request.setAttribute("totalTime", totalTime);

        return "fcresponse";
    }
}
