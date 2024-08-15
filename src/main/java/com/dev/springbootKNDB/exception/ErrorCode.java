package com.dev.springbootKNDB.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGOZIZED_EXCEPTION(9999,"UNCATEGOZIZED ERROR", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_EXISTED(1002,"User existed",HttpStatus.BAD_REQUEST),
    INVALID_KEY(1001,"Invalid message key",HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003,"USERNAME MUST BE AT LEAST 3 CHARACTRES",HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1004,"PASSWORD MUST BE AT LEAST 8 CHARACTRES",HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005,"User NOT existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006,"ANUNTHETICATED", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007,"You do not have permission", HttpStatus.FORBIDDEN)
    ;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private int code;
    private String message;
    private HttpStatusCode statusCode;

}
