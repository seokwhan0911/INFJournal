package com.um5th.hackerthon.infjournal.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class TopicResponseDto {

    @Getter
    @Setter
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class TodayTopicResponseDto {

        @Schema(description = "주제 아이디", example = "1")
        private Long topicId;
        @Schema(description = "주제 내용", example = "주제입니다")
        private String contents;
        @Schema(description = "해당 주제에 대해 에세이 작성 여부", example = "true")
        private Boolean isWritten;
    }
}
