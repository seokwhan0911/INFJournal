package com.um5th.hackerthon.infjournal.converter;

import com.um5th.hackerthon.infjournal.controller.dto.request.EssayRequestDTO;
import com.um5th.hackerthon.infjournal.controller.dto.response.EssayResponseDTO;
import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.Topic;
import com.um5th.hackerthon.infjournal.domain.enums.MoodType;
import com.um5th.hackerthon.infjournal.repository.TopicRepository;
import com.um5th.hackerthon.infjournal.service.EssayService;
import com.um5th.hackerthon.infjournal.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EssayConverter {
    private static TopicService topicService;

    public static EssayResponseDTO.WriteEssayDTO toWriteResultDTO(Essay essay){
        return EssayResponseDTO.WriteEssayDTO.builder()
                .essayId(essay.getId())
                .userId(essay.getMember().getId())
                .build();
    }

    public static Essay toEssay(EssayRequestDTO.EssayDto request, Topic topic, Member member){
        MoodType moodType = MoodType.valueOf(request.getMood().toUpperCase());

        return Essay.builder()
                .title(request.getTitle())
                .contents(request.getContents())
                .moodType(moodType)
                .topic(topic)
                .member(member)
                .build();
    }

    public static EssayResponseDTO.readEssayDTO toReadEssayResDTO(Essay essay) {
       return EssayResponseDTO.readEssayDTO.builder()
               .essayId(essay.getId())
               .title(essay.getTitle())
               .contents(essay.getContents())
               .nickname(essay.getMember().getNickname())
               .moodType(String.valueOf(essay.getMoodType()))
               .build();
    }

    private static EssayResponseDTO.MyEssayDTO myEssayDTO(Essay essay, Member member){

        return EssayResponseDTO.MyEssayDTO.builder()
                .essayId(essay.getId())
                .topicId(essay.getTopic().getId())
                .title(essay.getTitle())
                .contents(essay.getContents())
                .moodType(String.valueOf(essay.getMoodType()))
                .likeCnt(essay.getEssayLikes().size())
                .build();
    }

    public static List<EssayResponseDTO.MyEssayDTO> toMyEssayDtoList(List<Essay> essays, Member member) {
        return essays.stream().map(essay -> myEssayDTO(essay, member)).toList();
    }
}
