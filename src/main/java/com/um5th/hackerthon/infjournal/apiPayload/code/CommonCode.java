package com.um5th.hackerthon.infjournal.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum CommonCode implements BaseCode {
    OK(HttpStatus.OK, "COMM_001", "요청 성공"),
    CREATED(HttpStatus.CREATED, "COMM_002", "요청 성공 및 리소스 생성됨"),

    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "SERVER_ERROR", "서버 에러! 담당자에게 문의하세요."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;


}
