package com.um5th.hackerthon.infjournal.service.impl;

import com.um5th.hackerthon.infjournal.apiPayload.code.MemberCode;
import com.um5th.hackerthon.infjournal.apiPayload.exception.handler.MemberException;
import com.um5th.hackerthon.infjournal.controller.dto.request.MemberRequestDto.SignInRequestDto;
import com.um5th.hackerthon.infjournal.controller.dto.request.MemberRequestDto.SignUpRequestDto;
import com.um5th.hackerthon.infjournal.converter.MemberConverter;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.repository.MemberRepository;
import com.um5th.hackerthon.infjournal.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;


    @Override
    public Boolean isNicknameExists(String username) {
        return memberRepository.existsByNickname(username);
    }

    @Override
    @Transactional
    public Member createMember(SignUpRequestDto request) {
        Member member = memberRepository.save(MemberConverter.toMember(request));

        return member;
    }

    @Override
    @Transactional
    public Member signIn(SignInRequestDto request) {
        Member member = memberRepository.findByNickname(request.getNickname()).orElseThrow(() -> new MemberException(MemberCode.MEMBER_NOT_FOUND));

        return member;
    }
}
