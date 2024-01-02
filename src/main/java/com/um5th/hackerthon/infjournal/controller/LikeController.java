package com.um5th.hackerthon.infjournal.controller;

import com.um5th.hackerthon.infjournal.apiPayload.BaseResponseDto;
import com.um5th.hackerthon.infjournal.apiPayload.code.CommonCode;
import com.um5th.hackerthon.infjournal.controller.dto.request.LikeRequestDTO;
import com.um5th.hackerthon.infjournal.controller.dto.response.LikeResponseDTO;
import com.um5th.hackerthon.infjournal.converter.EssayLikeConverter;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayLike;
import com.um5th.hackerthon.infjournal.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/essays")
public class LikeController {

    private final LikeService likeService;

    // 좋아요 등록
    @PostMapping("/{essayId}/likes")
    public ResponseEntity<BaseResponseDto<LikeResponseDTO.insertLike>> insertLike(@RequestBody LikeRequestDTO.insertLike request,
                                                                                  @PathVariable(name = "essayId") Long essayId) {
        EssayLike newEssayLike = likeService.insertLike(request, essayId);
        return ResponseEntity.status(CommonCode.CREATED.getHttpStatus())
                .body(BaseResponseDto.of(CommonCode.CREATED,
                        EssayLikeConverter.toEssayLikeResDTO(newEssayLike)));
    }
}
