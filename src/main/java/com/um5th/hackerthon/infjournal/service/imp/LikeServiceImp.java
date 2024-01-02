package com.um5th.hackerthon.infjournal.service.imp;

import com.um5th.hackerthon.infjournal.apiPayload.code.EssayCode;
import com.um5th.hackerthon.infjournal.apiPayload.code.MemberCode;
import com.um5th.hackerthon.infjournal.apiPayload.exception.handler.EssayHandler;
import com.um5th.hackerthon.infjournal.apiPayload.exception.handler.MemberException;
import com.um5th.hackerthon.infjournal.controller.dto.request.LikeRequestDTO;
import com.um5th.hackerthon.infjournal.converter.EssayLikeConverter;
import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayLike;
import com.um5th.hackerthon.infjournal.repository.EssayLikeRepository;
import com.um5th.hackerthon.infjournal.repository.EssayRepository;
import com.um5th.hackerthon.infjournal.repository.MemberRepository;
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
    private final MemberRepository memberRepository;


    @Override
    @Transactional
    public EssayLike insertLike(Member member, Long essayId) {
        Essay essay = essayRepository.findById(essayId).orElseThrow(() -> new EssayHandler(EssayCode.ESSAY_NOT_FOUND));
        //Member member = memberRepository.findById(request.getUserId()).orElseThrow(() -> new MemberException(MemberCode.MEMBER_NOT_FOUND));
        EssayLike newEssayLike = EssayLikeConverter.toEssayLike(essay, member);
        return essayLikeRepository.save(newEssayLike);
    }
}
