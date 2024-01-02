package com.um5th.hackerthon.infjournal.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class EssayResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WriteEssayDTO {

        @Schema(description = "작성된 에세이의 아이디", example = "1")
        Long essayId;
        Long userId;
    }


}
