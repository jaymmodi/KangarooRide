package com.ride.services;

import com.ride.DAO.DateTimeDAO;
import com.ride.Model.StartEndSlot;
import com.ride.Model.TimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmmodi on 11/13/2015.
 */

@Service
public class DateTimeSlotService {

    @Autowired
    DateTimeDAO dateTimeDAO;

    public ArrayList<String> getTimeSlotsFor(String date) {

        int rows = dateTimeDAO.getRowCountForThisDate(date);
        StartEndSlot startEndSlot = dateTimeDAO.getStartSlot();

        if (rows > 0) {
            List<TimeSlot> timeSlotList = dateTimeDAO.getSlotsFor(date);
            return convertToListString(timeSlotList, startEndSlot);
        } else {
            batchInsert(startEndSlot,date);
            return allSlots(startEndSlot);
        }
    }

    private void batchInsert(StartEndSlot startEndSlot, String date) {
        int slots = getTotalNumberOfSlots(startEndSlot);
        dateTimeDAO.batchInsert(slots,date);
    }

    private ArrayList<String> allSlots(StartEndSlot startEndSlot) {
        int totalNumberOfSlots = getTotalNumberOfSlots(startEndSlot);
        List<TimeSlot> timeSlots = new ArrayList<>();

        for (int i = 1; i <= totalNumberOfSlots; i++) {
            TimeSlot timeSlot = new TimeSlot();
            timeSlot.setSlotNumber(i);
            timeSlots.add(timeSlot);
        }
        return convertToListString(timeSlots, startEndSlot);

    }

    private int getTotalNumberOfSlots(StartEndSlot startEndSlot) {
        int hourDiff = hourDiff(startEndSlot.getEndHour(), startEndSlot.getStartHour(), startEndSlot.getStartMeridian(), startEndSlot.getEndMeridian());
        int minDiff = minDiff(startEndSlot.getEndMin(), startEndSlot.getStartMin());

        int totalMins = hourDiff * 60 + minDiff;
        return totalMins / startEndSlot.getDuration();
    }

    private int minDiff(int endMin, int startMin) {
        int diff = endMin - startMin;
        if (diff < 0) {
            return 60 - diff;
        }
        return diff;
    }

    private int hourDiff(int endHour, int startHour, String startMeridian, String endMeridian) {
        if (endMeridian.equals("PM")) {
            endHour = endHour + 12;
        }
        if (startMeridian.equals("PM")) {
            startHour = startHour + 12;
        }
        return endHour - startHour;
    }

    private ArrayList<String> convertToListString(List<TimeSlot> timeSlotList, StartEndSlot startEndSlot) {
        List<String> slots = new ArrayList<>();
        String slotInString;

        for (TimeSlot timeSlot : timeSlotList) {
            slotInString = makeTimeSlots(timeSlot, startEndSlot);
            slots.add(slotInString);
        }
        return (ArrayList<String>) slots;
    }

    private String makeTimeSlots(TimeSlot timeSlot, StartEndSlot startEndSlot) {

        int slotNumber = timeSlot.getSlotNumber();

        int startHour = startEndSlot.getStartHour();
        int startMin = startEndSlot.getStartMin() + (slotNumber - 1) * startEndSlot.getDuration();
        String startMeridian = "AM";
        String endMeridian = "AM";

        if (startMin > 60) {
            startHour = startHour + (startMin / 60);
            if (startMin % 60 == 0) {
                startMin = 0;
            } else {
                startMin = startEndSlot.getDuration();
            }
        }

        int endMin = startMin + startEndSlot.getDuration();
        int endHour = startHour;

        if (endMin == 60) {
            endHour++;
            endMin = 0;
        }

        startHour = day12HourClock(startHour);
        startMeridian = getMeridian(startHour, startMeridian);

        endHour = day12HourClock(endHour);
        endMeridian = getMeridian(endHour, endMeridian);

        setToTimeSlot(timeSlot, startHour, startMin);

        return String.format("%d.%02d%s-%d.%02d%s", startHour, startMin, startMeridian, endHour, endMin, endMeridian);
    }

    private void setToTimeSlot(TimeSlot timeSlot, int startHour, int startMin) {
        timeSlot.setHourStart(startHour);
        timeSlot.setMinStart(startMin);
    }

    public int day12HourClock(int hour) {
        if (hour > 12) {
            hour = hour % 12;
        }
        return hour;
    }


    public String getMeridian(int hour, String meridian) {
        if (hour >= 12) {
            meridian = "PM";
        } else {
            meridian = "AM";
        }
        return meridian;
    }
}
