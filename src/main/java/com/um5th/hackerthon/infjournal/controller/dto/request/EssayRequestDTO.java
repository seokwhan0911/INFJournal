package com.um5th.hackerthon.infjournal.controller.dto.request;

import com.um5th.hackerthon.infjournal.validation.annotation.ExistTopics;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

public class EssayRequestDTO {

    @Getter
    public static class EssayDto {

        @Schema(description = "오늘의 기분", allowableValues = {"HAPPY", "SAD", "ANGRY", "BOMB", "NERVOUS", "LOVE", "SICK"}, example = "HAPPY")
        String mood;

        @Schema(description = "관련 주제", example = "1")
        @ExistTopics
        Long topicId;

        @Schema(description = "제목", example = "제목입니다.")
        String title;

        @Schema(description = "내용", example = "내용입니다.")
        String contents;
    }

}
