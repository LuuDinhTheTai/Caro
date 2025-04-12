package com.utc.btl.exception;

import lombok.Getter;

@Getter
public enum ExceptionType {

    USERNAME_EXISTED_EXCEPTION("Username already existed."),
    ACCOUNT_NOT_EXISTED_EXCEPTION("Account not existed."),
    EMPTY_USERNAME_EXCEPTION("Username is empty."),
    EMPTY_PASSWORD_EXCEPTION("Password is empty."),
    EMPTY_CONFIRM_PASSWORD_EXCEPTION("Confirm password is empty."),
    CONFIRM_PASSWORD_NOT_MATCH_EXCEPTION("Confirm password does not match."),
    SYSTEM_ERROR("System error."),
    LOAD_ASSETS_FAILED_EXCEPTION("Load assets failed."),
    WRONG_PASSWORD_EXCEPTION("Password is incorrect."),
    COULD_NOT_MAP_FROM_RESULT_EXCEPTION("Couldn't map entity from result set."),
    ENTITY_NOT_FOUND_EXCEPTION("Entity not found."),
    CONNECT_TO_DATABASE_EXCEPTION("Connect to Database failed."),
    COULD_NOT_LIST_DATA_EXCEPTION("Couldn't list data."),
    COULD_NOT_DELETE_ENTITY_EXCEPTION("Couldn't delete entity."),
    COULD_NOT_FIND_ENTITY_EXCEPTION("Couldn't find entity."),
    ;

    private String message;

    ExceptionType(String message) {
        this.message = message;
    }
}
