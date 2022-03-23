package com.theatmo.databaseconnection.exception;

import com.theatmo.customexception.exception.CustomException;

public class ConnectionFailedException extends CustomException {

    /**
     * Throws ConnectionFailedException when database connection is failed.
     *
     * @param message
     */
    public ConnectionFailedException(final String message) {
        super(message);
    }
}

