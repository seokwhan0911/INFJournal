package com.um5th.hackerthon.infjournal.service.imp;

import com.um5th.hackerthon.infjournal.apiPayload.code.EssayCode;
import com.um5th.hackerthon.infjournal.apiPayload.exception.handler.EssayHandler;
import com.um5th.hackerthon.infjournal.converter.EssayLikeConverter;
import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayLike;
import com.um5th.hackerthon.infjournal.repository.EssayLikeRepository;
import com.um5th.hackerthon.infjournal.repository.EssayRepository;
import com.um5th.hackerthon.infjournal.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeServiceImp implements LikeService {

    private final EssayLikeRepository essayLikeRepository;
    private final EssayRepository essayRepository;


    @Override
    @Transactional
    public EssayLike insertLike(Member member, Long essayId) {
        Essay essay = essayRepository.findById(essayId).orElseThrow(() -> new EssayHandler(EssayCode.ESSAY_NOT_FOUND));
        EssayLike essayLike = essayLikeRepository.findByMemberAndEssay(member, essay).orElse(null);

        System.out.println(essayLike);
        if (essayLike != null) {
            essayLikeRepository.delete(essayLike);
            essayLike = null;
        }

        else {
            essayLike = EssayLikeConverter.toEssayLike(essay, member);
            essayLikeRepository.save(essayLike);
        }
        return essayLike;
    }

    /*@Override
    @Transactional
    public Integer countLike(Long essayId) {
        Essay essay = essayRepository.findById(essayId).orElseThrow(() -> new EssayHandler(EssayCode.ESSAY_NOT_FOUND));
        System.out.println(essayLikeRepository.countByEssay(essay));
        return essayLikeRepository.countByEssay(essay);
    }*/
}
