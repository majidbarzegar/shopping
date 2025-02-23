package com.penovatech.shopping.exception;

import com.penovatech.common.exception.ExceptionMessage;

public enum ShoppingExceptionMessage implements ExceptionMessage {
    CAN_NOT_SAVE_FILE(1001),
    INVALID_JSON_INPUT(1002),
    INVALID_USERNAME_OR_PASSWORD(1003),
    USER_NOT_AUTHORIZATION(1004),
    CAN_NOT_DELETE_FILE(1005),
    USER_WITH_THIS_EMAIL_IS_EXIST(1006),
    ;

    private final Integer code;

    ShoppingExceptionMessage(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessageKey() {
        return this.name();
    }

}