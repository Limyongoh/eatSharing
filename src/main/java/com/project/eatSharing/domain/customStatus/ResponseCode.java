package com.project.eatSharing.domain.customStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ResponseCode {

    SUCCESS(HttpStatus.OK, "success"),
    LOGIN_FAIL(HttpStatus.UNAUTHORIZED, "로그인실패입니다.");



    private final HttpStatus httpStatus;
    private final String message;

}
