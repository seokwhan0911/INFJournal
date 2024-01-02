package com.um5th.hackerthon.infjournal.apiPayload.exception.handler;

import com.um5th.hackerthon.infjournal.apiPayload.code.BaseCode;
import com.um5th.hackerthon.infjournal.apiPayload.exception.BaseException;

public class RootException extends BaseException {

    public RootException(BaseCode baseCode) {
        super(baseCode);
    }
}
