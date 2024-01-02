package com.um5th.hackerthon.infjournal.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MemberResponseDto {

    @Getter
    @Setter
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class SignUpResponseDto {

        @Schema(description = "생성된 사용자의 아이디", example = "1")
        private Long userId;
    }

    @Getter
    @Setter
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class SignInResponseDto {

        @Schema(description = "로그인한 사용자의 아이디", example = "1")
        private Long userId;
    }

    @Getter
    @Setter
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class InboxEssayPreviewResponseDto {

        @Schema(description = "에세이 아이디", example = "1")
        private Long essayId;

        @Schema(description = "주제", example = "오늘의 주제입니다.")
        private String topic;

        @Schema(description = "좋아요 여부", example = "true")
        private Boolean isLiked;

        @Schema(description = "스크랩 여부", example = "true")
        private Boolean isScraped;

        @Schema(description = "좋아요 타입", allowableValues = {"HEART"})
        private String likeType;

        @Schema(description = "무드 타입", allowableValues = {"HAPPY", "SAD", "ANGRY", "BOMB", "NERVOUS", "LOVE", "SICK"})
        private String moodType;
    }
}
