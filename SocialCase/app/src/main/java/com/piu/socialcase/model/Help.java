package com.piu.socialcase.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Help implements Serializable {

    private Volunteer volunteer;
    private SocialCase socialCase;
    private Date date;
    private TypeHelp type;
    private String description;
    private boolean presenceConfirmed;

    public Help(Volunteer volunteer, SocialCase socialCase, Date date, TypeHelp type, String description) {
        this.volunteer = volunteer;
        this.socialCase = socialCase;
        this.date = date;
        this.type = type;
        this.description = description;
        this.presenceConfirmed = false;
    }

    public Help(SocialCase socialCase, Date date, TypeHelp type, String description) {
        this.socialCase = socialCase;
        this.date = date;
        this.type = type;
        this.description = description;
        this.presenceConfirmed = false;
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

    public boolean isPresenceConfirmed() {
        return presenceConfirmed;
    }

    public void setPresenceConfirmed(boolean presenceConfirmed) {
        this.presenceConfirmed = presenceConfirmed;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Help help = (Help) o;
        return Objects.equals(volunteer, help.volunteer) &&
                Objects.equals(socialCase, help.socialCase) &&
                Objects.equals(date, help.date) &&
                type == help.type &&
                Objects.equals(description, help.description);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(volunteer, socialCase, date, type, description);
    }
}
