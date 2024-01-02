package com.um5th.hackerthon.infjournal.converter;

import com.um5th.hackerthon.infjournal.controller.dto.request.MemberRequestDto.SignUpRequestDto;
import com.um5th.hackerthon.infjournal.controller.dto.response.MemberResponseDto.InboxEssayPreviewResponseDto;
import com.um5th.hackerthon.infjournal.controller.dto.response.MemberResponseDto.SignInResponseDto;
import com.um5th.hackerthon.infjournal.controller.dto.response.MemberResponseDto.SignUpResponseDto;
import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayLike;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayScrap;
import com.um5th.hackerthon.infjournal.domain.mapping.TodayTopic;
import java.util.List;
import java.util.Optional;

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

    public static List<InboxEssayPreviewResponseDto> toInboxEssayPreviewResponseDtoList(List<Essay> essays, Member member) {
        return essays.stream()
                     .map(essay -> toInboxEssayPreviewResponseDto(essay, member))
                     .toList();
    }

    private static InboxEssayPreviewResponseDto toInboxEssayPreviewResponseDto(Essay essay, Member member) {
        Optional<EssayLike> essayLike = essay.getEssayLikes()
                                             .stream()
                                             .filter(like -> like.getMember().getId().equals(member.getId()))
                                             .findFirst();

        Optional<EssayScrap> essayScrap = essay.getEssayScraps()
                                               .stream()
                                               .filter(scrap -> scrap.getMember().getId().equals(member.getId()))
                                               .findFirst();

        return InboxEssayPreviewResponseDto.builder()
                                           .essayId(essay.getId())
                                           .topic(essay.getTopic().getContents())
                                           .isLiked(essayLike.isPresent())
                                           .isScraped(essayScrap.isPresent())
                                           .moodType(essay.getMoodType().toString())
                                           .likeType(essayLike.map(like -> like.getLikeType().toString()).orElse(null))
                                           .build();
    }
}
