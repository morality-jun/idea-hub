package com.junshijun.hub.idea.common.exception;

public class LoginNameExistException extends RuntimeException {

    public LoginNameExistException() {
        super("This Login Name Has Already Exist!");
    }

    public LoginNameExistException(String message) {
        super(message);
    }
}
