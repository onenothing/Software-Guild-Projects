/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.tipcalculator;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
public class TipCalculator {

    double serviceTotal;
    double percent;
    double totalWithTip;

    public TipCalculator(double serviceTotal, double percent) {
        this.serviceTotal = serviceTotal;
        this.percent = percent;
    }

    public double CalculateTip() {

        double tip = (serviceTotal * (percent / 100));
        totalWithTip = tip + serviceTotal;
        return tip;
    }

}
