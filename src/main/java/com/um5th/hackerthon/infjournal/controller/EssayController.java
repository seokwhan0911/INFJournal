package com.um5th.hackerthon.infjournal.controller;

import com.um5th.hackerthon.infjournal.annotation.ExtractMember;
import com.um5th.hackerthon.infjournal.apiPayload.BaseResponseDto;
import com.um5th.hackerthon.infjournal.apiPayload.code.CommonCode;
import com.um5th.hackerthon.infjournal.controller.dto.request.EssayRequestDTO;
import com.um5th.hackerthon.infjournal.controller.dto.response.EssayResponseDTO;
import com.um5th.hackerthon.infjournal.converter.EssayConverter;
import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.common.BaseEntity;
import com.um5th.hackerthon.infjournal.service.EssayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EssayController {
    private final EssayService essayService;
    @Operation(summary = "에세이 등록 API", description = "에세이 글쓰기 ")
    @ApiResponse(responseCode = "201")
    @PostMapping("/essays")
    public ResponseEntity<BaseResponseDto<EssayResponseDTO.WriteEssayDTO>> write(@RequestBody @Valid EssayRequestDTO.EssayDto request, @Parameter(hidden = true) @ExtractMember Member member){
        Essay essay = essayService.writeEssay(request, member);
        return ResponseEntity
                .status(CommonCode.CREATED.getHttpStatus())
                .body(BaseResponseDto.of(CommonCode.CREATED, EssayConverter.toWriteResultDTO(essay)));
    }

    @Operation(summary = "에세이 상세조회 API")
    @GetMapping("/essays/{essayId}")
    public ResponseEntity<BaseResponseDto<EssayResponseDTO.readEssayDTO>> readEssay(@PathVariable(name = "essayId") Long essayId) {
        Essay essay = essayService.getEssay(essayId);
        return ResponseEntity.status(CommonCode.OK.getHttpStatus())
                .body(BaseResponseDto.of(CommonCode.OK, EssayConverter.toReadEssayResDTO(essay)));
    }
}
