package com.um5th.hackerthon.infjournal.controller;

import com.um5th.hackerthon.infjournal.annotation.ExtractMember;
import com.um5th.hackerthon.infjournal.apiPayload.BaseResponseDto;
import com.um5th.hackerthon.infjournal.apiPayload.code.CommonCode;
import com.um5th.hackerthon.infjournal.controller.dto.request.EssayScrapRequestDTO;
import com.um5th.hackerthon.infjournal.controller.dto.response.EssayScrapResponseDTO;
import com.um5th.hackerthon.infjournal.converter.EssayScrapConverter;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayScrap;
import com.um5th.hackerthon.infjournal.service.EssayScrapService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EssayScrapController {

    private final EssayScrapService essayScrapService;

    //에세이 스크랩 추가
    @Operation(summary = "에세이 스크랩 API", description = "스크랩")
  //  @ApiResponse(responseCode = "201")
    @PostMapping("/me/scrap")
    public ResponseEntity<BaseResponseDto<EssayScrapResponseDTO.AddResultEssayScrapDto>> addScrap(@RequestBody @Valid EssayScrapRequestDTO.AddEssayScrapDto request,
                                                                                                  @Parameter(hidden = true) @ExtractMember Member member){

        System.out.println(request.getEssayId());
        EssayScrap essayScrap = essayScrapService.addScrap(request, member);
        return ResponseEntity
                .status(CommonCode.CREATED.getHttpStatus())
                .body(BaseResponseDto.of(CommonCode.CREATED, EssayScrapConverter.toAddResultEssayScrapDto(essayScrap, member)));
    }


}
