package com.ride.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by jmmodi on 11/12/2015.
 */

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;


    public void sendEmail(final String emailAddress, String code) {
        String text = "Congratulations on booking a ride with Crazy Calvin's Kangaroo Rides and your confirmation Code is " + code;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailAddress);
        message.setSubject("KangarooRide - ConfirmationCode");
        message.setText(text);
        mailSender.send(message);
    }
}
