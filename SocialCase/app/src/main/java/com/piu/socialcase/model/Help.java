package com.piu.socialcase.model;

import java.io.Serializable;
import java.util.Date;

public class Help implements Serializable {

    private Volunteer volunteer;
    private SocialCase socialCase;
    private Date date;
    private TypeHelp type;
    private String description;

    public Help(Volunteer volunteer, SocialCase socialCase, Date date, TypeHelp type, String description) {
        this.volunteer = volunteer;
        this.socialCase = socialCase;
        this.date = date;
        this.type = type;
        this.description = description;
    }

    public Help(SocialCase socialCase, Date date, TypeHelp type, String description) {
        this.socialCase = socialCase;
        this.date = date;
        this.type = type;
        this.description = description;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public Help setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
        return this;
    }

    public SocialCase getSocialCase() {
        return socialCase;
    }

    public Help setSocialCase(SocialCase socialCase) {
        this.socialCase = socialCase;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Help setDate(Date date) {
        this.date = date;
        return this;
    }

    public TypeHelp getType() {
        return type;
    }

    public Help setType(TypeHelp type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Help setDescription(String description) {
        this.description = description;
        return this;
    }
}
