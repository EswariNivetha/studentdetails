package com.theatmo.studentmanagement.exception;

import com.theatmo.customexception.exception.CustomException;
/**
 * IdAlreadyFoundException.
 *
 * @author EswariNivethaVU
 */
public class IdAlreadyFoundException extends CustomException {

    /**
     * Throws IdAlreadyFoundException when given id already exist.
     *
     * @param msg
     */
    public IdAlreadyFoundException(String msg) {
        super(msg);
    }
}
