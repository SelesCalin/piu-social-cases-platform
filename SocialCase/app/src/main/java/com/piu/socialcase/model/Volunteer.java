package com.piu.socialcase.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Volunteer implements Serializable {

    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private String address;
    private String organisation;
    private String[] preferences;

    public Volunteer(){}

    public Volunteer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Volunteer(String username, String password, String email, String phoneNumber, String organisation) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.organisation = organisation;
    }

    public Volunteer(String username, String password, String email, String phoneNumber, String birthDate, String address, String organisation, String[] preferences) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = address;
        this.organisation = organisation;
        this.preferences=preferences;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getPreferences() {
        return preferences;
    }

    public void setPreferences(String[] preferences) {
        this.preferences = preferences;
    }
}
