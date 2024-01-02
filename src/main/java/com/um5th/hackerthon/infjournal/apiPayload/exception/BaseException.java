package com.um5th.hackerthon.infjournal.apiPayload.exception;

import com.um5th.hackerthon.infjournal.apiPayload.code.BaseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BaseException extends RuntimeException {
    private final BaseCode baseCode;
}
