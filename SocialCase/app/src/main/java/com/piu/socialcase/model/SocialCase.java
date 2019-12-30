package com.piu.socialcase.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class SocialCase implements Serializable {

    private String name;
    private String phoneNumber;
    private Date birthDate;
    private String address;
    private Double latitude;
    private Double longitude;

    public SocialCase(String name, String phoneNumber, Date birthDate, String address, Double latitude, Double longitude) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public SocialCase setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public SocialCase setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public SocialCase setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public SocialCase setAddress(String address) {
        this.address = address;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public SocialCase setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public SocialCase setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialCase that = (SocialCase) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(address, that.address) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, birthDate, address, latitude, longitude);
    }
}
