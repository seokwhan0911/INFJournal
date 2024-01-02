package com.um5th.hackerthon.infjournal.validation.validator;

import com.um5th.hackerthon.infjournal.apiPayload.code.EssayCode;
import com.um5th.hackerthon.infjournal.repository.TopicRepository;
import com.um5th.hackerthon.infjournal.service.EssayService;
import com.um5th.hackerthon.infjournal.service.TopicService;
import com.um5th.hackerthon.infjournal.validation.annotation.ExistTopics;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TopicsExistValidator implements ConstraintValidator<ExistTopics, Long> {
    private final TopicRepository topicRepository;

    private final TopicService topicService;

    @Override
    public void initialize(ExistTopics constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = topicService.isTopicExist(value);
        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(EssayCode.TOPIC_NOT_EXISTS.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
