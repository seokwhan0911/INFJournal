package com.um5th.hackerthon.infjournal.service.impl;

import com.um5th.hackerthon.infjournal.controller.dto.request.MemberRequestDto.SignUpRequestDto;
import com.um5th.hackerthon.infjournal.converter.MemberConverter;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.repository.MemberRepository;
import com.um5th.hackerthon.infjournal.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
