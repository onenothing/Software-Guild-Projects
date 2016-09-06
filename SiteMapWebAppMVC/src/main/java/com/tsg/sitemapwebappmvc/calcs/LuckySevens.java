/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.sitemapwebappmvc.calcs;

import com.tsg.sitemapwebappmvc.dto.Lucky7Vars;
import java.util.Random;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
public class LuckySevens {

    int startBet;
    private Lucky7Vars stats;

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
