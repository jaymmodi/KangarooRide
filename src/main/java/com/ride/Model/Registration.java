package com.ride.Model;

import java.util.Date;

/**
 * Created by jmmodi on 11/10/2015.
 */
public class Registration {

    int registration_id;
    String user_id;
    int ride_id;
    Date ride_date;
    String ride_time;
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getRide_id() {
        return ride_id;
    }

    public void setRide_id(int ride_id) {
        this.ride_id = ride_id;
    }

    public Date getRide_date() {
        return ride_date;
    }

    public void setRide_date(Date ride_date) {
        this.ride_date = ride_date;
    }

    public String getRide_time() {
        return ride_time;
    }

    public void setRide_time(String ride_time) {
        this.ride_time = ride_time;
    }
}
