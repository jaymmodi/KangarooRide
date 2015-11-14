package com.ride.controllers;

import com.ride.Model.FormDetails;
import com.ride.Model.Rides;
import com.ride.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmmodi on 11/9/2015.
 */

@Controller
public class FormController {

    @Autowired
    ValidationService validationService;

    @Autowired
    EmailSenderService emailSenderService;

    @Autowired
    ConfirmationCodeService confirmationCodeService;

    @Autowired
    DateTimeSlotService dateTimeSlotService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String goToHelloPage(Model model) {
        model.addAttribute("formDetails", new FormDetails());
        model.addAttribute("rides", getAllRides());
        return "form";
    }

    @RequestMapping(value = "/getSlots", method = RequestMethod.GET)
    @ResponseBody
    private ArrayList<String> getTimeSlots(@RequestParam("date") String date) {
        return dateTimeSlotService.getTimeSlotsFor(date);
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String postForm(@ModelAttribute FormDetails formDetails, Model model) {
        model.addAttribute("formDetails", formDetails);

        List<String> errorMessageList = validationService.getErrorMessage(formDetails);

        if (errorMessageList.size() == 0) {
            userService.storeUser(formDetails);
            String code = confirmationCodeService.createUUIDString(formDetails);
            emailSenderService.sendEmail(formDetails.getEmailAddress(), code);
            dateTimeSlotService.update(formDetails.getDate());
            model.addAttribute("code", code);
        } else {

        }
        return "result";
    }

    public String[] getAllRides() {
        return Rides.names();
    }
}
