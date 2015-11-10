package com.ride.Model;

import java.util.Date;

/**
 * Created by jmmodi on 11/10/2015.
 */
public class Registration {

    int registration_id;
    int user_id;
    int ride_id;
    Date ride_dateTime;
    String comments;


    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    public int getRegistration_id() {
        return registration_id;
    }

    public void setRegistration_id(int registration_id) {
        this.registration_id = registration_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRide_id() {
        return ride_id;
    }

    public void setRide_id(int ride_id) {
        this.ride_id = ride_id;
    }

    public Date getRide_dateTime() {
        return ride_dateTime;
    }

    public void setRide_dateTime(Date ride_dateTime) {
        this.ride_dateTime = ride_dateTime;
    }
}
