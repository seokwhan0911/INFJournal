package com.um5th.hackerthon.infjournal;

import com.um5th.hackerthon.infjournal.apiPayload.code.CommonCode;
import com.um5th.hackerthon.infjournal.apiPayload.exception.handler.RootException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping()
    public Void test() {
        throw new RootException(CommonCode.INTERNAL_ERROR);
    }
}
