package com.um5th.hackerthon.infjournal.service;

import com.um5th.hackerthon.infjournal.apiPayload.exception.BaseException;
import com.um5th.hackerthon.infjournal.controller.dto.request.EssayRequestDTO;
import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.Topic;
import com.um5th.hackerthon.infjournal.repository.EssayRepository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface EssayService {
    Essay writeEssay(EssayRequestDTO.EssayDto request, Member member);

    List<Essay> getMyEssay(Member member) throws BaseException;

}
