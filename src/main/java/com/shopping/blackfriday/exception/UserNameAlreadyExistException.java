package com.shopping.blackfriday.exception;

public class UserNameAlreadyExistException extends RuntimeException {
    public UserNameAlreadyExistException(String message) {
        super(message);
    }

    public UserNameAlreadyExistException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
