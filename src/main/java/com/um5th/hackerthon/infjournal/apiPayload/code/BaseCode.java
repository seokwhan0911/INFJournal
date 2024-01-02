package com.um5th.hackerthon.infjournal.apiPayload.code;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public interface BaseCode {
    HttpStatus getHttpStatus();
    String getCode();
    String getMessage();
}
