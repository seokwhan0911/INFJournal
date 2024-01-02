package com.um5th.hackerthon.infjournal.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class EssayResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WriteEssayDTO{
        Long essayId;
        Long userId;
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
