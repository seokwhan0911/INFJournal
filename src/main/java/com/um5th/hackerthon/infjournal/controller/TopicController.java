package com.um5th.hackerthon.infjournal.controller;

import com.um5th.hackerthon.infjournal.annotation.ExtractMember;
import com.um5th.hackerthon.infjournal.apiPayload.BaseResponseDto;
import com.um5th.hackerthon.infjournal.apiPayload.code.CommonCode;
import com.um5th.hackerthon.infjournal.controller.dto.response.TopicResponseDto.TodayTopicResponseDto;
import com.um5th.hackerthon.infjournal.converter.TopicConverter;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.TodayTopic;
import com.um5th.hackerthon.infjournal.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/topics")
@Tag(name = "Topic", description = "토픽 관련 API")
public class TopicController {

    private final TopicService topicService;

    @GetMapping("/today")
    @Operation(summary = "오늘의 주제 조회 API", description = "오늘의 주제를 조회합니다.")
    public ResponseEntity<BaseResponseDto<TodayTopicResponseDto>> getTodayTopic(@Parameter(hidden = true) @ExtractMember Member member) {
        TodayTopic todayTopic = topicService.getTodayTopic(member);

        return ResponseEntity.status(CommonCode.OK.getHttpStatus())
                             .body(BaseResponseDto.of(TopicConverter.toTodayTopicResponseDto(todayTopic, member)));
    }
}
