package com.um5th.hackerthon.infjournal.service.impl;

import com.um5th.hackerthon.infjournal.apiPayload.code.MemberCode;
import com.um5th.hackerthon.infjournal.apiPayload.exception.handler.MemberException;
import com.um5th.hackerthon.infjournal.controller.dto.request.MemberRequestDto.SignInRequestDto;
import com.um5th.hackerthon.infjournal.controller.dto.request.MemberRequestDto.SignUpRequestDto;
import com.um5th.hackerthon.infjournal.converter.MemberConverter;
import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.Inbox;
import com.um5th.hackerthon.infjournal.repository.InboxRepository;
import com.um5th.hackerthon.infjournal.repository.MemberRepository;
import com.um5th.hackerthon.infjournal.service.MemberService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final InboxRepository inboxRepository;


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
    @Transactional(readOnly = true)
    public Member signIn(SignInRequestDto request) {
        Member member = memberRepository.findByNickname(request.getNickname()).orElseThrow(() -> new MemberException(MemberCode.MEMBER_NOT_FOUND));

        return member;
    }

    @Override
    @Transactional(readOnly = true)
    public Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new MemberException(MemberCode.MEMBER_NOT_FOUND));
    }

    @Override
    @Transactional(readOnly = false)
    public List<Essay> getInboxEssays(Member member) {
        return member.getInboxList().stream().map(Inbox::getEssay).toList();
    }

    @Override
    @Transactional
    public void sendEssayToRandomMember(Essay essay) {
        Long totalMemberCount = memberRepository.count();

        Random random = new Random();
        List<Long> randomIdList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Long randomId = random.nextLong(1, totalMemberCount + 1);
            if (randomIdList.stream().anyMatch(id -> id.equals(randomId))) {
                i--;
            } else {
                randomIdList.add(randomId);
            }
        }

        List<Inbox> inboxes = random.longs(5, 1, totalMemberCount + 1)
                                    .mapToObj(randomMemberId -> {
                                        Member randomMember = memberRepository.findById(randomMemberId).get();
                                        return Inbox.builder()
                                                    .member(randomMember)
                                                    .essay(essay)
                                                    .build();
                                    })
                                    .toList();

        inboxRepository.saveAll(inboxes);
    }
}
