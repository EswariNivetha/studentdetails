package com.theatmo.databaseconnection.exception;

import com.theatmo.customexception.exception.CustomException;
/**
 * ConnectionFailedException.
 *
 * @author EswariNivethaVU
 */
public class ConnectionFailedException extends CustomException {

    /**
     * Throws ConnectionFailedException when database connection is failed.
     *
     * @param msg
     */
        public ConnectionFailedException(String msg) {
            super(msg);
        }
    }

