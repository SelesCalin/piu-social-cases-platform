package com.piu.socialcase.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Volunteer implements Serializable {

    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private String address;
    private String organisation;
    private String[] preferences;
    private int accepted=0;
    private Map<String,Boolean> available = new HashMap<>();

    public Volunteer(){}

    public Volunteer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Volunteer(String username, String password, String email, String phoneNumber, String organisation) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName="User";
        this.address="Adresa";
        this.preferences=new String[1];
        this.birthDate="10/10/10";
        this.phoneNumber = phoneNumber;
        this.organisation = organisation;
        this.accepted=1;
    }

    public Volunteer(String username, String password, String email, String phoneNumber,String fullName, String birthDate, String address, String organisation, String[] preferences) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = address;
        this.organisation = organisation;
        this.preferences=preferences;
        this.fullName=fullName;
        this.accepted=0;
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

    public Map<String, Boolean> getAvailable() {
        return available;
    }

    public void setAvailable(Map<String, Boolean> available) {
        this.available = available;
    }

    public void setOneAvailable(String key, Boolean value) {
        this.available.put(key,value);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean getOneAvailable(String key) {
        if(this.available.get(key)!=null)
            return this.available.get(key);
        return false;
    }

    public int getAccepted() {
        return accepted;
    }

    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volunteer volunteer = (Volunteer) o;
        return Objects.equals(username, volunteer.username) &&
                Objects.equals(password, volunteer.password) &&
                Objects.equals(fullName, volunteer.fullName) &&
                Objects.equals(email, volunteer.email) &&
                Objects.equals(phoneNumber, volunteer.phoneNumber) &&
                Objects.equals(birthDate, volunteer.birthDate) &&
                Objects.equals(address, volunteer.address) &&
                Objects.equals(organisation, volunteer.organisation);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(username, password, fullName, email, phoneNumber, birthDate, address, organisation);
    }
}
