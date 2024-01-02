package com.um5th.hackerthon.infjournal.controller.dto.response;

import com.um5th.hackerthon.infjournal.domain.Essay;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyEssayDTO{
        Long essayId;
        Long topicId;
        String title;
        String contents;
        String moodType;
        Integer likeCnt;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class readEssayDTO {
        Long essayId;
        String title;
        String contents;
        String nickname;
        String moodType;
    }
}
