package com.theatmo.studentmanagement.exception;

import com.theatmo.customexception.exception.CustomException;

public class SqlQueryException extends CustomException {

    /**
     * Throws SqlQueryException when given query is invalid.
     *
     * @param message
     */
    public SqlQueryException(final String message) {
        super(message);
    }
}
