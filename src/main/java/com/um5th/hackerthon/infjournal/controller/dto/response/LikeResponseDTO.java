package com.um5th.hackerthon.infjournal.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class LikeResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class insertLike {
        Boolean isLiked;
        //Integer likeCnt;
    }

}
