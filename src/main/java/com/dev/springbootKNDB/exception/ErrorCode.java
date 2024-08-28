package com.dev.springbootKNDB.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
//      NGOAI LE TONG
    UNCATEGOZIZED_EXCEPTION(9999,"UNCATEGOZIZED ERROR", HttpStatus.INTERNAL_SERVER_ERROR),
//      nguoi dung da ton tai
    USER_EXISTED(1002,"User existed",HttpStatus.BAD_REQUEST),
//      sai key cung cap o request
    INVALID_KEY(1001,"Invalid message key",HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003,"USERNAME MUST BE AT LEAST 3 CHARACTRES",HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1004,"PASSWORD MUST BE AT LEAST 8 CHARACTRES",HttpStatus.BAD_REQUEST),
//      nguoi dung khong ton tai
    USER_NOT_EXISTED(1005,"User NOT existed", HttpStatus.NOT_FOUND),
//      untoken
    UNAUTHENTICATED(1006,"ANUNTHETICATED", HttpStatus.UNAUTHORIZED),
//      ko dc cap quyen
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
