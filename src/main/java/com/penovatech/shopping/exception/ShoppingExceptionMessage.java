package com.penovatech.shopping.exception;

import com.penovatech.common.exception.ExceptionMessage;

public enum ShoppingExceptionMessage implements ExceptionMessage {
    CAN_NOT_SAVE_FILE(1001, "CAN_NOT_SAVE_FILE"),
    INVALID_JSON_INPUT(1002, "INVALID_JSON_INPUT"),
    INVALID_USERNAME_OR_PASSWORD(1003, "INVALID_USERNAME_OR_PASSWORD"),
    USER_NOT_AUTHORIZATION(1004, "USER_NOT_AUTHORIZATION"),
    CAN_NOT_DELETE_FILE(1005, "CAN_NOT_DELETE_FILE"),
    ;

    private Integer code;
    private String messageKey;

    ShoppingExceptionMessage(Integer code, String messageKey) {
        this.code = code;
        this.messageKey = messageKey;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessageKey() {
        return messageKey;
    }

}