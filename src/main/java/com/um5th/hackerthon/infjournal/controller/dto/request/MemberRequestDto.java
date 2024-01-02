package com.um5th.hackerthon.infjournal.controller.dto.request;

import com.um5th.hackerthon.infjournal.validation.annotation.ValidateNickname;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class MemberRequestDto {

    @Getter
    @Setter
    public static class SignUpRequestDto {

        @NotBlank
        @ValidateNickname
        @Schema(description = "사용자 닉네임", example = "보노")
        private String nickname;
    }
}
