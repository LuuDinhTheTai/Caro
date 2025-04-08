package com.utc.btl.exception;

public class AppException extends RuntimeException {

    private CustomException customException;

    public AppException(CustomException customException) {
        super(customException.getMessage());
        this.customException = customException;
    }
}
