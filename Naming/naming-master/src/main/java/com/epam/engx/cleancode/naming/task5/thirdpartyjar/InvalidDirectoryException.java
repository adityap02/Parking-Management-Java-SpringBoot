package com.epam.engx.cleancode.naming.task5.thirdpartyjar;

public class InvalidDirectoryException extends RuntimeException{
    String message;
    public InvalidDirectoryException(String s) {
        super();
        this.message = s;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
