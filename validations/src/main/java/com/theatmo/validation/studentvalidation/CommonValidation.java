package com.theatmo.validation.studentvalidation;

import com.theatmo.validation.exception.InValidDateException;

import java.time.LocalDate;

/**
 * CommonValidation Implementation.
 *
 * @author EswariNivethaVU
 */
public class CommonValidation {

    /**
     * Validates the PhoneNumber.
     *
     * @param phoneNumber
     */
    public boolean validatePhoneNo(final String phoneNumber) {
        return phoneNumber.matches("[6-9]{1}[0-9]{9}") ? true : false;
    }

    /**
     * Validates the Name.
     *
     * @param name
     */
    public boolean validateName(final String name) {
        return name.matches("[a-zA-Z\\s]*$") ? true : false;
    }

    /**
     * Validates the EmailId.
     * "
     *
     * @param emailId
     */
    public boolean validateEmailId(final String emailId) {
        return emailId.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-z]{2,3}+$") ? true : false;
    }

    /**
     * Validates the Date.
     *
     * @param date
     */
    public boolean validateDate(final String date) {

        try {
            LocalDate localdate = LocalDate.parse(date);
            LocalDate currentLocalDate = LocalDate.now();

            return (currentLocalDate.plusDays(1).isAfter(localdate)) ? true : false;
        } catch (Exception e) {
            throw new InValidDateException("Invalid Date");
        }
    }
}
