package com.ride.services;

import com.ride.DAO.RegistrationDAO;
import com.ride.DAO.RideDAO;
import com.ride.DAO.UserDAO;
import com.ride.Model.FormDetails;
import com.ride.Model.Registration;
import com.ride.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jmmodi on 11/13/2015.
 */
@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    RegistrationDAO registrationDAO;

    @Autowired
    RideDAO rideDAO;

    public void storeUser(FormDetails formDetails) {
        User user = makeUser(formDetails);
        if (userDAO.getUser(user.getEmailAddress()) == 0) {
            userDAO.insert(user);
        }

        int id = rideDAO.getId(formDetails.getRideName());

        Registration registration = makeRegistration(formDetails, id);
        registrationDAO.insert(registration);
    }

    private Registration makeRegistration(FormDetails formDetails, int id) {
        Registration registration = new Registration();
        if (formDetails.getComments() != null) {
            registration.setComments(formDetails.getComments());
        }
        registration.setRide_id(id);
        registration.setUser_id(formDetails.getEmailAddress());
        registration.setRide_time(formDetails.getTime());

        try {
            Date utilDate = new SimpleDateFormat("yyyy/MM/dd").parse(formDetails.getDate());
            registration.setRide_date(utilDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return registration;
    }

    private User makeUser(FormDetails formDetails) {
        User user = new User();
        user.setFirstName(formDetails.getFirstName());
        user.setLastName(formDetails.getLastName());
        user.setEmailAddress(formDetails.getEmailAddress());
        user.setPhoneNumber(formDetails.getPhoneNumber());
        return user;
    }


}
