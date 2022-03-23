package com.theatmo.studentmanagement.exception;

import com.theatmo.customexception.exception.CustomException;

public class IdAlreadyFoundException extends CustomException {

    /**
     * Throws IdAlreadyFoundException when given id already exist.
     *
     * @param message
     */
    public IdAlreadyFoundException(final String message) {
        super(message);
    }
}
