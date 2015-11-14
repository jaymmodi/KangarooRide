package com.ride.services;

import com.ride.Model.FormDetails;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jmmodi on 11/12/2015.
 */

@Service
public class ConfirmationCodeService {
    public String createUniqueCode(FormDetails formDetails) {
        String uniqueString = formDetails.getDate() + formDetails.getTime() + formDetails.getEmailAddress();
        StringBuffer hexString = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(uniqueString.getBytes());
            byte[] messageByte = messageDigest.digest();

            hexString = new StringBuffer();
            for (int i = 0; i < messageByte.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageByte[i]));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }
}
