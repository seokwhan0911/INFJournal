package com.um5th.hackerthon.infjournal.converter;

import com.um5th.hackerthon.infjournal.controller.dto.response.LikeResponseDTO;
import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayLike;


public class EssayLikeConverter {
    public static LikeResponseDTO.insertLike toEssayLikeResDTO(EssayLike essayLike) {
        return LikeResponseDTO.insertLike.builder()
                .createdAt(essayLike.getCreatedAt())
                .likeId(essayLike.getId())
                .build();
    }

    public static EssayLike toEssayLike(Essay essay, Member member) {
        return EssayLike.builder()
                .essay(essay)
                .member(member)
                .build();
    }
}
