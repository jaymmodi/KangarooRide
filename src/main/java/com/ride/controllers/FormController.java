package com.ride.controllers;

import com.ride.Model.FormDetails;
import com.ride.Model.Registration;
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

    @Autowired
    RegistrationService registrationService;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String goToHelloPage(Model model) {
        model.addAttribute("formDetails", new FormDetails());
        model.addAttribute("rides", getAllRides());
        return "form";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdminPage(Model model) {
        List<Registration> allRegistrations;
        allRegistrations = registrationService.getAllRegistrations();

        model.addAttribute("registration", allRegistrations);
        return "admin";
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

            int slotNumber = dateTimeSlotService.getSlotNumber(formDetails.getTime());
            dateTimeSlotService.update(slotNumber);

            String code = confirmationCodeService.createUniqueCode(formDetails);
            model.addAttribute("code", code);

            emailSenderService.sendEmail(formDetails.getEmailAddress(), code);
            return "result";
        } else {
            model.addAttribute("errorMessageList", errorMessageList);
            model.addAttribute("formDetails", new FormDetails());
            model.addAttribute("rides", getAllRides());
            return "form";
        }
    }

    public String[] getAllRides() {
        return Rides.names();
    }
}
