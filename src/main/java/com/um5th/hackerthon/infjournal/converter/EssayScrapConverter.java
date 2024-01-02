package com.um5th.hackerthon.infjournal.converter;

import com.um5th.hackerthon.infjournal.controller.dto.request.EssayScrapRequestDTO;
import com.um5th.hackerthon.infjournal.controller.dto.response.EssayScrapResponseDTO;
import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayScrap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class EssayScrapConverter {
    public static EssayScrapResponseDTO.AddResultEssayScrapDto toAddResultEssayScrapDto(EssayScrap essayScrap, Member member){

        return EssayScrapResponseDTO.AddResultEssayScrapDto.builder()
                .scrapId(essayScrap.getId())
                .build();
    }

    public static EssayScrap toEssayScrap(EssayScrapRequestDTO.AddEssayScrapDto request, Essay essay, Member member){
        return EssayScrap.builder()
                .essay(essay)
                .member(member)
                .build();
    }
}
