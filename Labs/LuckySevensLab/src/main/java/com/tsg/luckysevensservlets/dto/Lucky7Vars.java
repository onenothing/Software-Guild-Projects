/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.luckysevensservlets.dto;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
public class Lucky7Vars {
    
     private int totalRolls;
     private int maxDollars;
     private int maxDollarRolls;

    public int getTotalRolls() {
        return totalRolls;
    }

    public void setTotalRolls(int totalRolls) {
        this.totalRolls = this.totalRolls + 1;
    }

    public int getMaxDollars() {
        return maxDollars;
    }

    public void setMaxDollars(int maxDollars) {
        this.maxDollars = maxDollars;
    }

    public int getMaxDollarRolls() {
        return maxDollarRolls;
    }

    public void setMaxDollarRolls(int maxDollarRolls) {
        this.maxDollarRolls = maxDollarRolls;
    }
     
}
