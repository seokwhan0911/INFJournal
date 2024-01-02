package com.um5th.hackerthon.infjournal.service;

import com.um5th.hackerthon.infjournal.controller.dto.request.EssayRequestDTO;
import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.Topic;

public interface EssayService {
    Essay writeEssay(EssayRequestDTO.EssayDto request, Member member);


}
