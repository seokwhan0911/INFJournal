package com.um5th.hackerthon.infjournal.annotation.resolver;

import com.um5th.hackerthon.infjournal.annotation.ExtractMember;
import com.um5th.hackerthon.infjournal.apiPayload.code.CommonCode;
import com.um5th.hackerthon.infjournal.apiPayload.code.MemberCode;
import com.um5th.hackerthon.infjournal.apiPayload.exception.handler.MemberException;
import com.um5th.hackerthon.infjournal.apiPayload.exception.handler.RootException;
import com.um5th.hackerthon.infjournal.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@RequiredArgsConstructor
public class ExtractMemberArgumentResolver implements HandlerMethodArgumentResolver {

    private final MemberService memberService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(ExtractMember.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
        WebDataBinderFactory binderFactory) throws Exception {
        String authorizationHeaderValue = webRequest.getHeader("Authorization");
        if (authorizationHeaderValue != null) {
            Long memberId;
            try {
                memberId = Long.valueOf(authorizationHeaderValue);
            } catch (NumberFormatException e) {
                throw new RootException(CommonCode.AUTH_HEADER_INVALID);
            }

            return memberService.findMemberById(memberId);
        }

        throw new MemberException(MemberCode.MEMBER_NOT_FOUND);
    }
}
