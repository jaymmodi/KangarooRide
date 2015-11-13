package com.ride.services;

import com.ride.Model.FormDetails;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * Created by jmmodi on 11/12/2015.
 */

@Service
public class ConfirmationCodeService {
    public String createUniqueCode(FormDetails formDetails) {
        String uniqueString = formDetails.getDate() + formDetails.getTime() + formDetails.getEmailAddress();
        String uniqueCode = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(uniqueString.getBytes());
            uniqueCode = new String(messageDigest.digest());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return uniqueCode;
    }

    public String createUUIDString(FormDetails formDetails) {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
