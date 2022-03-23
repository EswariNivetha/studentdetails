package com.theatmo.validation.exception;

import com.theatmo.customexception.exception.CustomException;
/**
 * InValidDateException.
 *
 * @author EswariNivethaVU
 */
public class InValidDateException extends CustomException {
    /**
     * Throws InValidDateException when given date is not valid.
     *
     * @param message
     */
    public InValidDateException(final String message) {
        super(message);
    }
}
