package com.ride.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;

/**
 * Created by jmmodi on 11/12/2015.
 */

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;


    public void sendEmail(final String emailAddress, String code) {
        String text = "Congratulations on booking a ride with Crazy Calvin's Kangaroo Rides and your confirmation Code is " + code;

        MimeMessagePreparator preparator = mimeMessage -> {
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
            mimeMessage.setFrom("modi.jay6@gmail.com");
            mimeMessage.setText(text);
            mimeMessage.setSubject("KangarooRide - ConfirmationCode");
        };

        this.mailSender.send(preparator);
    }
}
