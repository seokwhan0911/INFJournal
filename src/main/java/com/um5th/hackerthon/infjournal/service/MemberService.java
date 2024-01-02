package com.um5th.hackerthon.infjournal.service;

import com.um5th.hackerthon.infjournal.controller.dto.request.MemberRequestDto.SignInRequestDto;
import com.um5th.hackerthon.infjournal.controller.dto.request.MemberRequestDto.SignUpRequestDto;
import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;
import java.util.List;

public interface MemberService {

    Boolean isNicknameExists(String username);

    Member createMember(SignUpRequestDto request);

    Member signIn(SignInRequestDto request);

    Member findMemberById(Long memberId);

    List<Essay> getInboxEssays(Member member);

    void sendEssayToRandomMember(Essay essay);
}
