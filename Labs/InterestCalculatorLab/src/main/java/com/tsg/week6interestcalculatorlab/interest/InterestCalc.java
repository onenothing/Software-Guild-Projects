/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.week6interestcalculatorlab.interest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */



public class InterestCalc {

    double APR = 0;
    double initialPrincipal = 0;
    int years = 0;
    TypeOfCompounding compoundingType;
    List<YearlyInterestRecord> yearlyInterestList;

   
   public static enum TypeOfCompounding {
       
        QUARTERLY(4,"Q"),
        MONTHLY(12,"M"),
        DAILY(365,"D"),
        YEARLY(1,"Y"),
        ERROR(0,"",true,"Compounding Type must be (Q)uarterly, (M)onthly, (D)aily, or (Y)early");
        
        private int periods;
        private String abbrv;
        private boolean error;
        private String errorMessage;
        
        public static TypeOfCompounding fromAbbrv( String abbrv ) {
            switch ( abbrv.toUpperCase() ) {
                case "Q":
                    return QUARTERLY;
                case "M":
                    return MONTHLY;
                case "D":
                    return DAILY;
                case "Y":
                    return YEARLY;
                default:
                    return ERROR;
            }
        }

        private TypeOfCompounding(int periods, String abbrv) {
            this( periods, abbrv, false, null );
        }
        
        private TypeOfCompounding( int periods, String abbrv, boolean isError, String errorMessage ) {
            this.periods = periods;
            this.abbrv = abbrv;
            this.error = isError;
            this.errorMessage = errorMessage;
        }

        public int getPeriods() {
            return periods;
        }

        public String getAbbrv() {
            return abbrv;
        }  

        public boolean isError() {
            return error;
        }
        
        public double getPeriodicRate ( double APR ) {
            return APR / this.getPeriods();
        }

        public String getErrorMessage() {
            return errorMessage;
        }
        
   }
   
    public InterestCalc(double APR, double initialPrincipal, int years, TypeOfCompounding typeOfCompounding) {
        this.APR = APR;
        this.initialPrincipal = initialPrincipal;
        this.years = years;
        this.compoundingType = typeOfCompounding;
    }

    public List<YearlyInterestRecord> getYearlyInterestCalculations() {
        if ( yearlyInterestList == null ) {
            yearlyInterestList = new ArrayList<>();
            if ( !this.compoundingType.isError() ) populateYearlyInterestList();
        }
        return yearlyInterestList;
    }
    
    public String getError() {
        return this.compoundingType.getErrorMessage();
    }
    
    private void populateYearlyInterestList() {
        double prevTotal = this.initialPrincipal;
        for ( int i=0; i<years; i++ ) {
            double newTotal = computeNewTotalForYear(prevTotal);
            YearlyInterestRecord yir = new YearlyInterestRecord();
            yir.setYear(i+1);
            yir.setTotal(newTotal);
            yir.setInterestEarned(newTotal-prevTotal);
            prevTotal=newTotal;
            yearlyInterestList.add(yir);
        }
    }
 
    private double computeNewTotalForYear(double principal) {
            for (int j = 0; j < compoundingType.periods; j++) {
                principal += interestCalculation(principal);
            }
            return principal;
    }

    private double interestCalculation(double amt) {
        amt *= (this.compoundingType.getPeriodicRate(APR) / 100);
        return amt;
    }

 }
