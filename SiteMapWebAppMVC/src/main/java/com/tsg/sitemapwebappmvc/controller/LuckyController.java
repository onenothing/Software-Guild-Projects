/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.sitemapwebappmvc.controller;

import com.tsg.sitemapwebappmvc.dto.Lucky7Vars;
import java.util.Random;
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
public class LuckyController {

    int startBet;
    private Lucky7Vars stats;

    @RequestMapping(value = "/LuckyController", method = RequestMethod.GET)
    public String displayLuckyForm(HttpServletRequest req, Model model) {
        return "luckyindex";

    }

    @RequestMapping(value = "/LuckyController", method = RequestMethod.POST)
    public String getLuckyResults(HttpServletRequest request, Model model) {

        startBet = (Integer.parseInt(request.getParameter("myRolls")));

        rollDice(startBet);

        int rolls = stats.getTotalRolls();
        int bestRoll = stats.getMaxDollarRolls();
        int bestBet = stats.getMaxDollars();

        request.setAttribute("startBet", startBet);
        request.setAttribute("rolls", rolls);
        request.setAttribute("bestRoll", bestRoll);
        request.setAttribute("bestBet", bestBet);

        return "luckyresponse";

    }
    public void rollDice(int dollars) {
        
        stats = new Lucky7Vars();

        int dieTotal;
        Random die1 = new Random();
        Random die2 = new Random();
        stats.setMaxDollars(dollars);
        stats.setMaxDollarRolls(0);
        stats.setTotalRolls(0);

        while (dollars > 0) {
            dieTotal = (die1.nextInt(6) + 1) + (die2.nextInt(6) + 1);
            stats.setTotalRolls(stats.getTotalRolls());

            if (dieTotal == 7) {
                dollars += 4;

                if (dollars > stats.getMaxDollarRolls()) {
                    stats.setMaxDollars(dollars);
                    stats.setMaxDollarRolls(stats.getTotalRolls());
                }

            } else {
                dollars -= 1;
            }
        }

    }

}
