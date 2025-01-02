package com.example.springrestapi.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Error {
    private LocalDate timestamp = LocalDate.now();
    private String message;
    private Exception exception;

    public Error(LocalDate timestamp, String message, Exception exception) {
        this.timestamp = timestamp;
        this.message = message;
        this.exception = exception;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
