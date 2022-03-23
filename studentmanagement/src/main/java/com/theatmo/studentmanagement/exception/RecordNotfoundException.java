package com.theatmo.studentmanagement.exception;

import com.theatmo.customexception.exception.CustomException;

public class RecordNotfoundException extends CustomException {

    /**
     * Throws RecordNotfoundException when given id is not found.
     *
     * @param message
     */
        public RecordNotfoundException(final String message)  {
            super(message);
        }
    }

