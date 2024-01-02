package com.um5th.hackerthon.infjournal.apiPayload.exception.handler;

import com.um5th.hackerthon.infjournal.apiPayload.code.BaseCode;
import com.um5th.hackerthon.infjournal.apiPayload.exception.BaseException;

public class MemberException extends BaseException {

    public MemberException(BaseCode baseCode) {
        super(baseCode);
    }
}
