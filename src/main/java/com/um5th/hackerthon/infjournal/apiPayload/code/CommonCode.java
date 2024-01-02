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
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMM_003", "요청 방식 에러, result를 확인하세요."),
    AUTH_HEADER_INVALID(HttpStatus.UNAUTHORIZED, "COMM_004", "Authorization 헤더가 적절한 값이 아닙니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;


}
