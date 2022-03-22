package com.theatmo.studentmanagement.exception;

import com.theatmo.customexception.exception.CustomException;

/**
 * SqlQueryException.
 *
 * @author EswariNivethaVU
 */
public class SqlQueryException extends CustomException {

    /**
     * Throws SqlQueryException when given query is invalid.
     *
     * @param msg
     */
    public SqlQueryException(String msg) {
        super(msg);
    }
}
