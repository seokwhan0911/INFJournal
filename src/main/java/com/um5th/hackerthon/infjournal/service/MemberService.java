package com.um5th.hackerthon.infjournal.service;

import com.um5th.hackerthon.infjournal.controller.dto.request.MemberRequestDto.SignInRequestDto;
import com.um5th.hackerthon.infjournal.controller.dto.request.MemberRequestDto.SignUpRequestDto;
import com.um5th.hackerthon.infjournal.domain.Member;

public interface MemberService {

    Boolean isNicknameExists(String username);

    Member createMember(SignUpRequestDto request);

    Member signIn(SignInRequestDto request);

    Member findMemberById(Long memberId);
}
