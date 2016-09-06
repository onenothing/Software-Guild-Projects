/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.contactlistmvc.dao;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
public enum SearchTerm {
    
    FIRSTNAME("like"), 
    LASTNAME("like"), 
    COMPANY("like"), 
    PHONE("like"), 
    EMAIL("like");
    
    //new functionality for SQL searches adding ("like") to enums to search partial like terms similar to .contains(lambda), but have to use % symbol
    private String searchOperator;
    
    private SearchTerm(String searchOperator) {
        this.searchOperator = searchOperator;
    }
    
    public String getSearchOperator() {
        return this.searchOperator;
    }
}
