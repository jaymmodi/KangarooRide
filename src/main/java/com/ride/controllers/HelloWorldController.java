package com.ride.controllers;

import Model.User;
import DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jmmodi on 11/9/2015.
 */

@Controller
public class HelloWorldController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/hello")
    public String goToHelloPage(Model model) {

        User u = new User();
        u.setFirstName("Jay");
        u.setLastName("Modi");
        u.setEmailAddress("modi.jay6@gmail.com");
        u.setPhoneNumber("8123696652");

        userDAO.create(u);

        return "hello";

    }
}
