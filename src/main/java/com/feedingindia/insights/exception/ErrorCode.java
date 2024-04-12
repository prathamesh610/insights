package com.feedingindia.insights.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "Internal Server Error"),
    EMPTY_CATEGORIES("ERR-01", "No categories saved. Please add some categories before performing this operation."),




    ;

    private final String code;
    private final String message;

    private ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
