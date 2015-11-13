package com.ride.Model;

/**
 * Created by jmmodi on 11/13/2015.
 */
public class StartEndSlot {

    int duration;
    int startHour;
    int startMin;
    String startMeridian;
    int endHour;
    int endMin;
    String endMeridian;

    public String getEndMeridian() {
        return endMeridian;
    }

    public void setEndMeridian(String endMeridian) {
        this.endMeridian = endMeridian;
    }

    public String getStartMeridian() {
        return startMeridian;
    }

    public void setStartMeridian(String startMeridian) {
        this.startMeridian = startMeridian;
    }

    public int getEndMin() {
        return endMin;
    }

    public void setEndMin(int endMin) {
        this.endMin = endMin;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMin() {
        return startMin;
    }

    public void setStartMin(int startMin) {
        this.startMin = startMin;
    }
}
