package com.um5th.hackerthon.infjournal.service.impl;

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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Override
    public Essay writeEssay(EssayRequestDTO.EssayDto request, Member member) {
        Topic topic = topicRepository.findById(request.getTopicId()).orElseThrow(() -> new RuntimeException());
        Essay newEssay = EssayConverter.toEssay(request, topic, member);
        return essayRepository.save(newEssay);
    }

    @Override
    public List<Essay> getMyEssay(Member member) throws BaseException {
        List<Essay> essay = essayRepository.findAllByMember(member);
       // EssayResponseDTO.MyEssayDTO dto = EssayConverter.myEssayDTO(essay, member);
        return essay;
    }


//    public EssayResponseDTO.MyEssayDTO getMyEssay(Essay essay, Member member) throws BaseException {
//
//    }


}
