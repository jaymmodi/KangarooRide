package com.ride.services;

import com.ride.DAO.RegistrationDAO;
import com.ride.Model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jmmodi on 11/14/2015.
 */
@Service
public class RegistrationService {

    @Autowired
    RegistrationDAO registrationDAO;

    public List<Registration> getAllRegistrations() {
        return registrationDAO.getAllRegistrations();
    }

    public void delete(String user_id, String ride_date, String ride_time) {
        Date utilDate = null;
        try {
            utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(ride_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        registrationDAO.deleteRegistration(user_id, utilDate, ride_time);
    }
}
