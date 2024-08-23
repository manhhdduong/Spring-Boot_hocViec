package com.microservice.mone.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
//    ngoai le tong
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
//    sai key cung cap o request(INVALID_PAWWWORD)
    INVALID_KEY(1001, "Uncategorized error", HttpStatus.BAD_REQUEST),
//    nguoi dung da ton tai
    USER_EXISTED(1002, "User existed", HttpStatus.BAD_REQUEST),
//    ngoai le username
    USERNAME_INVALID(1003, "Username must be at least {min} characters", HttpStatus.BAD_REQUEST),
//    ngoai le password
    INVALID_PASSWORD(1004, "Password must be at least {min} characters", HttpStatus.BAD_REQUEST),
//    nguoi dung khong ton tai
    USER_NOT_EXISTED(1005, "User not existed", HttpStatus.NOT_FOUND),
//    token khuong duoc xac thuc
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
//    khong duoc cap quyen
    UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN),

    INVALID_DOB(1008, "Your age must be at least {min}", HttpStatus.BAD_REQUEST),
    ;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;
}
