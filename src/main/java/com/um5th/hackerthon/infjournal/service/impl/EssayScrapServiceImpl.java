package com.um5th.hackerthon.infjournal.service.impl;

import com.um5th.hackerthon.infjournal.controller.dto.request.EssayScrapRequestDTO;
import com.um5th.hackerthon.infjournal.converter.EssayLikeConverter;
import com.um5th.hackerthon.infjournal.converter.EssayScrapConverter;
import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayScrap;
import com.um5th.hackerthon.infjournal.repository.EssayRepository;
import com.um5th.hackerthon.infjournal.repository.EssayScrapRepository;
import com.um5th.hackerthon.infjournal.service.EssayScrapService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EssayScrapServiceImpl implements EssayScrapService {
    private final EssayScrapRepository essayScrapRepository;
    private final EssayRepository essayRepository;

    @Override
    @Transactional
    public EssayScrap addScrap(EssayScrapRequestDTO.AddEssayScrapDto request, Member member){
        Essay essay = essayRepository.findById(request.getEssayId()).orElseThrow(() -> new RuntimeException());
       // EssayScrap newScrap = EssayScrapConverter.toEssayScrap(request, essay, member);
        EssayScrap essayScrap = essayScrapRepository.findByMemberAndEssay(member, essay);

        if (essayScrap != null) {
            essayScrapRepository.delete(essayScrap);
            essayScrap = null;
        }

        else {
            essayScrap = EssayScrapConverter.toEssayScrap(essay, member);
            essayScrapRepository.save(essayScrap);
        }
        return essayScrap;
        //return essayScrapRepository.save(newScrap);
    }

}
