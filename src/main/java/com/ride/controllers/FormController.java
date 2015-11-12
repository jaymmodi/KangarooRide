package com.ride.controllers;

import com.ride.DAO.UserDAO;
import com.ride.Model.FormDetails;
import com.ride.Model.Rides;
import com.ride.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by jmmodi on 11/9/2015.
 */

@Controller
public class FormController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    ValidationService validationService;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String goToHelloPage(Model model) {
        model.addAttribute("formDetails", new FormDetails());
        model.addAttribute("rides", getAllRides());
        return "form";
    }

    @RequestMapping(value = "/getSlots", method = RequestMethod.GET)
    @ResponseBody
    private ArrayList<String> getTimeSlots(@RequestParam("date") String date) {
        ArrayList<String> s = new ArrayList<>();
        s.add("8.00 AM- 8.30 AM");
        s.add("8.30 AM- 9:00 AM");

        return s;
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String postForm(@ModelAttribute FormDetails formDetails, Model model) {
        model.addAttribute("formDetails", formDetails);

        if(validationService.isValid(formDetails)){
            //save to db
            //return a confirmation code
            // also send an email to user
        }
        else{
            // validation message
            String message = validationService.getErrorMessage();
        }

        return "result";
    }

    public String[] getAllRides() {
        return Rides.names();
    }
}
