package com.ride.controllers;

import com.ride.DAO.UserDAO;
import com.ride.Model.FormDetails;
import com.ride.Model.Rides;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jmmodi on 11/9/2015.
 */

@Controller
public class FormController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String goToHelloPage(Model model) {
        model.addAttribute("formDetails", new FormDetails());
        model.addAttribute("rides", getAllRides());
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String postForm(@ModelAttribute FormDetails formDetails, Model model) {
        model.addAttribute("user", formDetails);

        return "result";
    }

    public String[] getAllRides() {
        return Rides.names();
    }
}
