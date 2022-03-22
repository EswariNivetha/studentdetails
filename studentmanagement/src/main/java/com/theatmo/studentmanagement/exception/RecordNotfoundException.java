package com.theatmo.studentmanagement.exception;

import com.theatmo.customexception.exception.CustomException;

/**
 * Record Not found Exception.
 *
 * @author EswariNivethaVU
 */
public class RecordNotfoundException extends CustomException {

    /**
     * Throws RecordNotfoundException when given id is not found.
     *
     * @param msg
     */
        public RecordNotfoundException(String msg) {
            super(msg);
        }
    }

