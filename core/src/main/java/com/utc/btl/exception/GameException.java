package com.utc.btl.exception;

public class GameException extends RuntimeException {

    public GameException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
    }
    public GameException(ExceptionType exceptionType, Throwable cause) {
        super(exceptionType.getMessage(), cause);
    }
}
