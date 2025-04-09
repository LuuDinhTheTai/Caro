package com.utc.btl.exception;

public class GameException extends RuntimeException {

    private ExceptionType exceptionType;

    public GameException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }
}
