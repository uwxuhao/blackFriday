package com.shopping.blackfriday.exception;

public class UserIdNameNotMatchException extends RuntimeException {
    public UserIdNameNotMatchException(String message) {
        super(message);
    }

    public UserIdNameNotMatchException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
