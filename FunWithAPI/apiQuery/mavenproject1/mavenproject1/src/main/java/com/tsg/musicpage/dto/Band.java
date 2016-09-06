/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.musicpage.dto;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
public class Band {

    private int bandId;
    private String bandName;
    private String songs;
    private String tourDates;
    private String website;
    private String email;

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getSongs() {
        return songs;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }

    public String getTourDates() {
        return tourDates;
    }

    public void setTourDates(String tourDates) {
        this.tourDates = tourDates;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
