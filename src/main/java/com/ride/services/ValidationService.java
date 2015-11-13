package com.ride.services;

import com.ride.Model.FormDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.apache.commons.collections.CollectionUtils.addIgnoreNull;

/**
 * Created by jmmodi on 11/12/2015.
 */
@Service
public class ValidationService {

    public List<String> getErrorMessage(FormDetails formDetails) {
        List<String> errorMessageList = new ArrayList<String>();

        addIgnoreNull(errorMessageList, isNull(formDetails.getFirstName()));
        addIgnoreNull(errorMessageList, isNull(formDetails.getLastName()));
        addIgnoreNull(errorMessageList, isNull(formDetails.getEmailAddress()));
        addIgnoreNull(errorMessageList, isNull(formDetails.getPhoneNumber()));
        addIgnoreNull(errorMessageList, isNull(formDetails.getRideName()));
        addIgnoreNull(errorMessageList, isNull(formDetails.getDate()));
        addIgnoreNull(errorMessageList, isNull(formDetails.getTime()));
//        addIgnoreNull(errorMessageList, isPerfectEmail(formDetails.getEmailAddress()));

        return errorMessageList;
    }

    private String isPerfectEmail(String emailAddress) {
        String pattern = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";

        boolean matches = Pattern.compile(pattern).matcher(emailAddress).matches();

        return matches ? null : "Please enter a valid email";
    }


    private String isNull(String field) {
        return (field == null) ? field + " is a required field" : null;
    }
}
