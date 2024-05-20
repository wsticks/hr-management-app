package com.hr.financemanager.exception;

public class AppException extends RuntimeException {

    AppException(String message) {
        super(message);
    }

    AppException(String message, Throwable cause) {
        super(message, cause);
        if (this.getCause() == null && cause != null) {
            this.initCause(cause);
        }
    }
}
