package com.um5th.hackerthon.infjournal.validation.validator;

import com.um5th.hackerthon.infjournal.apiPayload.code.MemberCode;
import com.um5th.hackerthon.infjournal.service.MemberService;
import com.um5th.hackerthon.infjournal.validation.annotation.ValidateNickname;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NicknameValidator implements ConstraintValidator<ValidateNickname, String> {

    private final MemberService memberService;

    @Override
    public void initialize(ValidateNickname constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = !memberService.isNicknameExists(s);

        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(MemberCode.NICKNAME_EXISTS.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
