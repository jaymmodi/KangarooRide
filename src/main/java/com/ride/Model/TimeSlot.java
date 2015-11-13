package com.ride.Model;

/**
 * Created by jmmodi on 11/13/2015.
 */
public class TimeSlot {

    int slotNumber;
    int duration;
    int hourStart;
    int minStart;

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getHourStart() {
        return hourStart;
    }

    public void setHourStart(int hourStart) {
        this.hourStart = hourStart;
    }

    public int getMinStart() {
        return minStart;
    }

    public void setMinStart(int minStart) {
        this.minStart = minStart;
    }
}
