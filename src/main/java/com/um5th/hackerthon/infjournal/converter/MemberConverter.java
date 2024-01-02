package com.um5th.hackerthon.infjournal.converter;

import com.um5th.hackerthon.infjournal.controller.dto.request.MemberRequestDto.SignUpRequestDto;
import com.um5th.hackerthon.infjournal.controller.dto.response.MemberResponseDto.SignInResponseDto;
import com.um5th.hackerthon.infjournal.controller.dto.response.MemberResponseDto.SignUpResponseDto;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.TodayTopic;

public class MemberConverter {

    public static SignUpResponseDto toSignUpResponseDto(Member member) {
        return SignUpResponseDto.builder()
                                .userId(member.getId())
                                .build();
    }

    public static Member toMember(SignUpRequestDto request) {
        Member member = Member.builder()
                              .nickname(request.getNickname())
                              .todayTopic(TodayTopic.builder()
                                                    .topic(null)
                                                    .build()
                              )
                              .build();

        member.getTodayTopic().setMember(member);

        return member;
    }

    public static SignInResponseDto toSignInResponseDto(Member member) {
        return SignInResponseDto.builder()
                                .userId(member.getId())
                                .build();
    }
}
