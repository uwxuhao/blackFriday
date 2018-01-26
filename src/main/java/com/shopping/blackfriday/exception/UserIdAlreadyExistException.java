package com.shopping.blackfriday.exception;

public class UserIdAlreadyExistException extends RuntimeException {
    public UserIdAlreadyExistException(String message) {
        super(message);
    }

    public UserIdAlreadyExistException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
