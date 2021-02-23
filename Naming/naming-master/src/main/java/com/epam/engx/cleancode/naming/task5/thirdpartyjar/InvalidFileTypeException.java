package com.epam.engx.cleancode.naming.task5.thirdpartyjar;

public class InvalidFileTypeException extends RuntimeException {
    String message;
    public InvalidFileTypeException(String fileTypeExceptionMessage) {
        super();
        this.message = fileTypeExceptionMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
