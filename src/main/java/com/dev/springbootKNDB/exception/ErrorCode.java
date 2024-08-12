package com.dev.springbootKNDB.exception;

public enum ErrorCode {
    UNCATEGOZIZED_EXCEPTION(9999,"UNCATEGOZIZED ERROR"),
    USER_EXISTED(1002,"User existed"),
    INVALID_KEY(1001,"Invalid message key"),
    USERNAME_INVALID(1003,"USERNAME MUST BE AT LEAST 3 CHARACTRES"),
    PASSWORD_INVALID(1004,"PASSWORD MUST BE AT LEAST 8 CHARACTRES"),
    USER_NOT_EXISTED(1005,"User NOT existed"),
    UNAUTHENTICATED(1006,"ANUNTHETICATED")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
