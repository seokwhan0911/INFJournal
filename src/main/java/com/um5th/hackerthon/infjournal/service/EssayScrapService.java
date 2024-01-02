package com.um5th.hackerthon.infjournal.service;

import com.um5th.hackerthon.infjournal.controller.dto.request.EssayScrapRequestDTO;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayScrap;


public interface EssayScrapService {
    EssayScrap addScrap(EssayScrapRequestDTO.AddEssayScrapDto request, Member member);
}
