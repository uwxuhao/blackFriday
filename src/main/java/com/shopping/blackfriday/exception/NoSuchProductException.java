package com.shopping.blackfriday.exception;

public class NoSuchProductException extends RuntimeException {
    public NoSuchProductException(String message) {
        super(message);
    }

    public NoSuchProductException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
