package com.uasz.enseign.exceptions;

public class UserNotExistsException extends IllegalArgumentException {
    public UserNotExistsException(String msg) {
        super(msg);
    }
}
