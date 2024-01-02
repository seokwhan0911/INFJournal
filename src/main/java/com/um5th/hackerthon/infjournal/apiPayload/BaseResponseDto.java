package com.um5th.hackerthon.infjournal.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.um5th.hackerthon.infjournal.apiPayload.code.BaseCode;
import com.um5th.hackerthon.infjournal.apiPayload.code.CommonCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
@Schema(description = "기본 응답")
public class BaseResponseDto<T> {

    private final Boolean isSuccess;
    private final String code;
    private final String message;
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
