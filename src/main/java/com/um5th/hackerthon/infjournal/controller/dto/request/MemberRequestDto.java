package com.um5th.hackerthon.infjournal.controller.dto.request;

import com.um5th.hackerthon.infjournal.validation.annotation.ValidateNickname;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class MemberRequestDto {

    @Getter
    @Setter
    public static class SignUpRequestDto {

        @NotBlank
        @ValidateNickname
        private String nickname;
    }
}
