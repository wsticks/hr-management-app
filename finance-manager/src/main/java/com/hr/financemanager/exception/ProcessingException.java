package com.hr.financemanager.exception;

public class ProcessingException extends AppException {


    public ProcessingException(String message) {
        super(message);
    }

    public ProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
