package com.ride.services;

import com.ride.DAO.RegistrationDAO;
import com.ride.Model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
