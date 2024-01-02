package com.um5th.hackerthon.infjournal.service.impl;

import com.um5th.hackerthon.infjournal.apiPayload.code.EssayCode;
import com.um5th.hackerthon.infjournal.apiPayload.exception.handler.EssayHandler;
import com.um5th.hackerthon.infjournal.apiPayload.exception.BaseException;
import com.um5th.hackerthon.infjournal.controller.dto.request.EssayRequestDTO;
import com.um5th.hackerthon.infjournal.controller.dto.response.EssayResponseDTO;
import com.um5th.hackerthon.infjournal.converter.EssayConverter;
import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.Topic;
import com.um5th.hackerthon.infjournal.repository.EssayLikeRepository;
import com.um5th.hackerthon.infjournal.repository.EssayRepository;
import com.um5th.hackerthon.infjournal.repository.TopicRepository;
import com.um5th.hackerthon.infjournal.service.EssayService;
import com.um5th.hackerthon.infjournal.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EssayServiceImpl implements EssayService {

    private final EssayRepository essayRepository;
    private final TopicRepository topicRepository;
    private final EssayLikeRepository essayLikeRepository;
    private final MemberService memberService;


  @Override
    public List<Essay> getMyEssay(Member member) throws BaseException {
        List<Essay> essay = essayRepository.findAllByMember(member);
       // EssayResponseDTO.MyEssayDTO dto = EssayConverter.myEssayDTO(essay, member);
        return essay;
    }


    @Override
    public Essay writeEssay(EssayRequestDTO.EssayDto request, Member member) {
        Topic topic = topicRepository.findById(request.getTopicId()).orElseThrow(() -> new RuntimeException());
        Essay newEssay = EssayConverter.toEssay(request, topic, member);

        newEssay = essayRepository.save(newEssay);
        memberService.sendEssayToRandomMember(newEssay);

        return newEssay;
    }

    @Override
    public Essay getEssay(Long essayId) {
        Essay essay = essayRepository.findById(essayId).orElseThrow(() -> new EssayHandler(EssayCode.ESSAY_NOT_FOUND));
        return essay;
    }
}
