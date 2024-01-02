package com.um5th.hackerthon.infjournal.apiPayload.exception;

import com.um5th.hackerthon.infjournal.apiPayload.BaseResponseDto;
import com.um5th.hackerthon.infjournal.apiPayload.code.BaseCode;
import com.um5th.hackerthon.infjournal.apiPayload.code.CommonCode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> validation(ConstraintViolationException e, WebRequest request) {
        String errorMessage = e.getConstraintViolations().stream()
                               .map(ConstraintViolation::getMessage)
                               .findFirst()
                               .orElseThrow(() -> new RuntimeException("ConstraintViolationException 추출 도중 에러 발생"));

        return handleExceptionInternalConstraint(e, CommonCode.valueOf(errorMessage), HttpHeaders.EMPTY, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatusCode status,
        WebRequest request) {
        Map<String, String> errors = new LinkedHashMap<>();

        e.getBindingResult().getFieldErrors()
         .forEach(fieldError -> {
             String fieldName = fieldError.getField();
             String errorMessage = Optional.ofNullable(fieldError.getDefaultMessage()).orElse("");
             errors.merge(fieldName, errorMessage, (existingErrorMessage, newErrorMessage) -> existingErrorMessage + ", " + newErrorMessage);
         });

        return handleExceptionInternalArgs(e, HttpHeaders.EMPTY, CommonCode.valueOf("BAD_REQUEST"), request, errors);
    }

    @ExceptionHandler
    public ResponseEntity<Object> anyException(Exception e, WebRequest request) {

        return handleExceptionInternalFalse(e, CommonCode.INTERNAL_ERROR, HttpHeaders.EMPTY, request);
    }

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<Object> onThrowException(BaseException baseException, HttpServletRequest request) {
        return handleExceptionInternal(baseException, request);
    }

    private ResponseEntity<Object> handleExceptionInternal(BaseException e, HttpServletRequest request) {

        BaseResponseDto<Object> body = BaseResponseDto.onFailure(e.getBaseCode(), null);

        WebRequest webRequest = new ServletWebRequest(request);
        return super.handleExceptionInternal(
            e,
            body,
            HttpHeaders.EMPTY,
            e.getBaseCode().getHttpStatus(),
            webRequest
        );
    }

    private ResponseEntity<Object> handleExceptionInternalFalse(Exception e, BaseCode code,
        HttpHeaders headers, WebRequest request) {
        BaseResponseDto<Object> body = BaseResponseDto.onFailure(code, null);
        return super.handleExceptionInternal(
            e,
            body,
            headers,
            code.getHttpStatus(),
            request
        );
    }

    private ResponseEntity<Object> handleExceptionInternalArgs(Exception e, HttpHeaders headers, BaseCode code,
        WebRequest request, Map<String, String> errorArgs) {
        BaseResponseDto<Object> body = BaseResponseDto.onFailure(code, errorArgs);

        return super.handleExceptionInternal(
            e,
            body,
            headers,
            code.getHttpStatus(),
            request
        );
    }

    private ResponseEntity<Object> handleExceptionInternalConstraint(Exception e, BaseCode code,
        HttpHeaders headers, WebRequest request) {
        BaseResponseDto<Object> body = BaseResponseDto.onFailure(code, null);
        return super.handleExceptionInternal(
            e,
            body,
            headers,
            code.getHttpStatus(),
            request
        );
    }
}
