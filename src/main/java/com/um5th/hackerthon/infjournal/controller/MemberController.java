package com.um5th.hackerthon.infjournal.controller;

import com.um5th.hackerthon.infjournal.apiPayload.BaseResponseDto;
import com.um5th.hackerthon.infjournal.apiPayload.code.CommonCode;
import com.um5th.hackerthon.infjournal.controller.dto.request.MemberRequestDto.SignUpRequestDto;
import com.um5th.hackerthon.infjournal.controller.dto.response.MemberResponseDto.SignUpResponseDto;
import com.um5th.hackerthon.infjournal.converter.MemberConverter;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api")
@Tag(name = "Member", description = "사용자 관련 API")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/sign-up")
    @Operation(summary = "회원 가입 API", description = "닉네임만 받아 회원가입을 진행합니다.")
    public ResponseEntity<BaseResponseDto<SignUpResponseDto>> signUp(@RequestBody @Valid SignUpRequestDto request) {
        Member member = memberService.createMember(request);

        return ResponseEntity
            .status(CommonCode.CREATED.getHttpStatus())
            .body(BaseResponseDto.of(CommonCode.CREATED, MemberConverter.toSignUpResponseDto(member)));
    }
}
