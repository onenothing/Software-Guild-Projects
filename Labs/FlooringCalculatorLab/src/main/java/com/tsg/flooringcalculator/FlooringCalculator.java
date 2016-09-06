/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.flooringcalculator;

import java.text.DecimalFormat;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
public class FlooringCalculator {

    double width;
    double length;
    double area;
    double costPerSqFt;
    double laborPerHr = 86.00;

    public FlooringCalculator(double width, double length, double costPerSqFt) {
        this.width = width;
        this.length = length;
        this.costPerSqFt = costPerSqFt;
    }

    public double getArea(double width, double length) {
        area = width * length;
        return area;
    }

    public double getMateialCost(double area, double materialCostSqFt) {
        double materialCost = area * materialCostSqFt;
        return materialCost;
    }

    public double getLaborRate() {

        double numOfHours = area / 20;
        double quarterlyRate = .25;

//        double incrementedRate = laborPerHr * quarterlyRate;
//        double incrementedLabor = numOfHours / quarterlyRate;

        DecimalFormat decimal = new DecimalFormat("#.##");
        Double.valueOf(decimal.format(quarterlyRate));

        double laborRate = numOfHours * laborPerHr;
        return laborRate;

    }

    public double getOrderTotal(double laborRate, double materialCost) {
        double orderTotal = (materialCost + laborRate);
        return orderTotal;
    }

}
