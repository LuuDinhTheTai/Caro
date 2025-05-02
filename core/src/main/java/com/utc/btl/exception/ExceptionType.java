package com.utc.btl.exception;

import lombok.Getter;

@Getter
public enum ExceptionType {

    SYSTEM_ERROR("System error."),
    LOAD_ASSETS_FAILED_EXCEPTION("Load assets failed."),

    CONNECT_TO_DATABASE_EXCEPTION("Could not connect to the database."),

    CREATE_ENTITY_EXCEPTION("Could not create entity."),
    FIND_ENTITY_EXCEPTION("Could not find entity."),
    LIST_ENTITY_EXCEPTION("Could not list entity."),
    UPDATE_ENTITY_EXCEPTION("Could not update entity."),
    DELETE_ENTITY_EXCEPTION("Could not delete entity."),

    ENTITY_NOT_FOUND_EXCEPTION("Entity not found."),
    COULD_NOT_MAP_FROM_RESULT_EXCEPTION("Could not map entity from result set."),
    ;

    private String message;

    ExceptionType(String message) {
        this.message = message;
    }
}
