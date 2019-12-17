package com.piu.socialcase.model;

import java.util.Date;

public class History {

    private String volunteerEmail;
    private String socialCaseName;
    private Date date;
    private String description;

    public History() {}

    public History(String socialCaseName, Date date, String description) {
        this.socialCaseName = socialCaseName;
        this.date = date;
        this.description = description;
    }

    public History(String volunteerEmail, String socialCaseName, Date date, String description) {
        this.volunteerEmail = volunteerEmail;
        this.socialCaseName = socialCaseName;
        this.date = date;
        this.description = description;
    }

    public String getVolunteerEmail() {
        return volunteerEmail;
    }

    public void setVolunteerEmail(String volunteerEmail) {
        this.volunteerEmail = volunteerEmail;
    }

    public String getSocialCaseName() {
        return socialCaseName;
    }

    public void setSocialCaseName(String socialCaseName) {
        this.socialCaseName = socialCaseName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
