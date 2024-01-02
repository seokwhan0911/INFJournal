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
    public static class WriteEssayDTO{
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


}
