package com.penovatech.shopping.exception;

import com.penovatech.common.exception.ExceptionMessage;

public enum ShoppingExceptionMessage implements ExceptionMessage {
    CAN_NOT_SAVE_FILE(1001, "CAN_NOT_SAVE_FILE")
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