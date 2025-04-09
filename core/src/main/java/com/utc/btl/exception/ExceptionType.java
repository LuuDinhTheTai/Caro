package com.utc.btl.exception;

import lombok.Getter;

@Getter
public enum ExceptionType {

    USERNAME_EXISTED("Username already existed"),
    ACCOUNT_NOT_EXISTED("Account not existed"),
    EMPTY_USERNAME("Username is empty"),
    EMPTY_PASSWORD("Password is empty"),
    EMPTY_CONFIRM_PASSWORD("Confirm password is empty"),
    CONFIRM_PASSWORD_NOT_MATCH("Confirm password does not match"),
    SYSTEM_ERROR("System error"),
    LOAD_ASSETS_FAILED("Load assets failed"),
    ;

    private String message;

    ExceptionType(String message) {
        this.message = message;
    }
}
