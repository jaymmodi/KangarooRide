package com.ride.services;

import com.ride.DAO.DateTimeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by jmmodi on 11/13/2015.
 */

@Service
public class DateTimeSlotService {

    @Autowired
    DateTimeDAO dateTimeDAO;

    public ArrayList<String> getTimeSlotsFor(String date) {
        return dateTimeDAO.getSlotsFor(date);
    }
}
