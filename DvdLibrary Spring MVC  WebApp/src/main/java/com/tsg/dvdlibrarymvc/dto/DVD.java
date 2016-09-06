/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.dvdlibrarymvc.dto;

import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Adam Coate <adamcoate1@gmail.com>
 */
public class DVD {

    private int dvdId;
    @NotEmpty(message = "You must supply a Dvd Title")
    @Length(max = 50, message = "Dvd title must be no more than 50 characters in length")
    private String dvdTitle;
    @NotEmpty(message = "You must supply a Director's Name")
    @Length(max = 50, message = "Director's name must be no more than 50 characters in length")
    private String directorsName;
    @NotEmpty(message = "You must supply an mpaa rating")
    @Length(max = 6, message = "Mpaa rating must be no more than 6 characters in length")
    private String mpaaRating;
    @NotEmpty(message = "You must supply a value for Studio")
    @Length(max = 50, message = "Studio must be no more than 50 characters in length")
    private String studio;
    @NotEmpty(message = "You must supply a value for Release Date")
    @Length(max = 6, message = "Release date must be no more than 6 characters in length")
    private String releaseDate;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.dvdId;
        hash = 29 * hash + Objects.hashCode(this.dvdTitle);
        hash = 29 * hash + Objects.hashCode(this.directorsName);
        hash = 29 * hash + Objects.hashCode(this.mpaaRating);
        hash = 29 * hash + Objects.hashCode(this.studio);
        hash = 29 * hash + Objects.hashCode(this.releaseDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
        if (this.dvdId != other.dvdId) {
            return false;
        }
        if (!Objects.equals(this.dvdTitle, other.dvdTitle)) {
            return false;
        }
        if (!Objects.equals(this.directorsName, other.directorsName)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        return true;
    }

    public int getDvdId() {
        return dvdId;
    }

    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }

    public String getDvdTitle() {
        return dvdTitle;
    }

    public void setDvdTitle(String dvdTitle) {
        this.dvdTitle = dvdTitle;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

}
