package com.um5th.hackerthon.infjournal.service;

import com.um5th.hackerthon.infjournal.apiPayload.exception.BaseException;
import com.um5th.hackerthon.infjournal.controller.dto.request.EssayRequestDTO;
import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;

import java.util.List;

public interface EssayService {
    Essay writeEssay(EssayRequestDTO.EssayDto request, Member member);

    Essay getEssay(Long essayId);

    List<Essay> getMyEssay(Member member) throws BaseException;

}
