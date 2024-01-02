package com.um5th.hackerthon.infjournal.apiPayload.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum MemberCode implements BaseCode {
    USERNAME_EXISTS(HttpStatus.CONFLICT, "MEM_001", "중복된 닉네임입니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
