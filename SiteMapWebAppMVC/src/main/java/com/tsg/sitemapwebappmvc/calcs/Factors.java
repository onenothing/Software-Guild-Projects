/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.sitemapwebappmvc.calcs;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
public class Factors {

    private int number;

    public Factors(int number) {
        this.number = number;
    }

    public String getFactors() {
        StringBuilder factors = new StringBuilder();
        for (int i = 1; i < this.number; i++) {
            if (this.number % i == 0) {
                if (factors.length() != 0) {
                    factors.append(", ");
                }
                factors.append(i);
            }
        }
        return factors.toString();
    }

    public Boolean isPerfect() {

        int perfectMatch = 0;
        for (int i = 1; i < this.number; i++) {
            if (this.number % i == 0) {
                perfectMatch = perfectMatch + i;
            }
        }

        //prints if perfect
        if (this.number == perfectMatch) {
            //System.out.println(this.number + " is a perfect number.");
            return true;
        } else {
            //System.out.println(this.number + " is not a perfect number.");
            return false;

        }
    }

    //checks for prime number
    public boolean isPrime() {
        int primeCheck = 0;
        for (int i = 2; i < this.number; i++) {
            if (this.number % i == 0) {
                primeCheck = primeCheck + 1;
            }
            //This if statement prints if the numbers prime or not.      
        }
        if (primeCheck > 0) {
            //System.out.println(this.number + " is not a prime number.");
            return false;
        }
//        else if (primeCheck == 0) {
//            System.out.println(this.number + " is a prime number.");
        return true;

    }

}
