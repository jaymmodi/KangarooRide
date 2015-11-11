package com.ride.Model;

import java.util.Date;

/**
 * Created by jmmodi on 11/10/2015.
 */
public class FormDetails {

    public String firstName;
    public String lastName;
    public String emailAddress;
    public String phoneNumber;
    public String address;
    public String rideName;
    public Date ride_dateTime;
    public String comments;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public Date getRide_dateTime() {
        return ride_dateTime;
    }

    public void setRide_dateTime(Date ride_dateTime) {
        this.ride_dateTime = ride_dateTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
