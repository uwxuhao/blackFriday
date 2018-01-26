package com.shopping.blackfriday.exception;

public class NoSuchUserException extends RuntimeException {
    public NoSuchUserException(String message) {
        super(message);
    }

    public NoSuchUserException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
