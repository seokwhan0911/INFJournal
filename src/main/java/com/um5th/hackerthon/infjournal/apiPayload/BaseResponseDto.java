package com.um5th.hackerthon.infjournal.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.um5th.hackerthon.infjournal.apiPayload.code.BaseCode;
import com.um5th.hackerthon.infjournal.apiPayload.code.CommonCode;
import com.um5th.hackerthon.infjournal.domain.Essay;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
@Schema(description = "기본 응답")
public class BaseResponseDto<T> {

    @Schema(description = "요청 성공 여부", example = "true")
    private final Boolean isSuccess;
    @Schema(description = "서버 커스텀 코드 (Http 상태 코드 ❌)", example = "COMM_001")
    private final String code;
    @Schema(description = "응답 메시지", example = "요청 성공")
    private final String message;
    @Schema(description = "응답 결과")
    @JsonInclude(Include.NON_NULL)
    private final T result;


    public static <T> BaseResponseDto<T> of(T result) {
        return new BaseResponseDto<>(true, CommonCode.OK.getCode(), CommonCode.OK.getMessage(), result);
    }

    public static <T> BaseResponseDto<T> of(BaseCode code, T result) {
        return new BaseResponseDto<>(true, code.getCode(), code.getMessage(), result);
    }

    public static <T> BaseResponseDto<T> onFailure(BaseCode code, T result) {
        return new BaseResponseDto<>(false, code.getCode(), code.getMessage(), result);
    }
}
