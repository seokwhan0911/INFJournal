package com.um5th.hackerthon.infjournal.converter;

import com.um5th.hackerthon.infjournal.controller.dto.response.TopicResponseDto.TodayTopicResponseDto;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.TodayTopic;

public class TopicConverter {

    public static TodayTopicResponseDto toTodayTopicResponseDto(TodayTopic todayTopic, Member member) {
        return TodayTopicResponseDto.builder()
                                    .topicId(todayTopic.getTopic().getId())
                                    .contents(todayTopic.getTopic().getContents())
                                    .isWritten(todayTopic.getTopic()
                                                         .getEssayList()
                                                         .stream()
                                                         .anyMatch(essay ->
                                                             essay.getMember().getId().equals(member.getId())))
                                    .build();
    }
}
