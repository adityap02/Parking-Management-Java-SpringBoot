package com.epam.engx.cleancode.comments.task1.thirdpartyjar;

public class InvalidInputException extends RuntimeException{
    String message;
    public InvalidInputException(String s) {
        super();
        this.message = s;

    }

    @Override
    public String getMessage() {
        return message;
    }

}
