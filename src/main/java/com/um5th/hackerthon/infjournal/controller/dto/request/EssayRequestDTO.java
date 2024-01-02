package com.um5th.hackerthon.infjournal.controller.dto.request;

import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.validation.annotation.ExistTopics;
import lombok.Getter;

public class EssayRequestDTO {

    @Getter
    public static class EssayDto{
        String mood;
        @ExistTopics
        Long topicId;
        String title;
        String contents;
    }

}
