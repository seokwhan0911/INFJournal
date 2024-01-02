package com.um5th.hackerthon.infjournal.controller;

import com.um5th.hackerthon.infjournal.annotation.ExtractMember;
import com.um5th.hackerthon.infjournal.apiPayload.BaseResponseDto;
import com.um5th.hackerthon.infjournal.apiPayload.code.CommonCode;
import com.um5th.hackerthon.infjournal.controller.dto.response.LikeResponseDTO;
import com.um5th.hackerthon.infjournal.converter.EssayLikeConverter;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayLike;
import com.um5th.hackerthon.infjournal.service.LikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/essays")
@Tag(name = "Like", description = "에세이 좋아요 관련 API")
public class LikeController {

    private final LikeService likeService;

    // 좋아요 등록
    @PostMapping("/{essayId}/likes")
    @Operation(summary = "에세이 좋아요 API")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<BaseResponseDto<LikeResponseDTO.insertLike>> insertLike(@Parameter(hidden = true) @ExtractMember Member member,
        @PathVariable(name = "essayId") @Parameter(description = "좋아요할 에세이 아이디", example = "1") Long essayId) {
        EssayLike newEssayLike = likeService.insertLike(member, essayId);
        //nteger likeCnt = likeService.countLike(essayId);
        return ResponseEntity.status(CommonCode.CREATED.getHttpStatus())
                             .body(BaseResponseDto.of(CommonCode.CREATED,
                                 EssayLikeConverter.toEssayLikeResDTO(newEssayLike)));
    }
}
