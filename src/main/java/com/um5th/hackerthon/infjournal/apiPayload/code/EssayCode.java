package com.um5th.hackerthon.infjournal.apiPayload.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum EssayCode implements BaseCode {
    ESSAY_NOT_FOUND(HttpStatus.NOT_FOUND, "ESS_001", "에세이가 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
