package com.um5th.hackerthon.infjournal.service;

import com.um5th.hackerthon.infjournal.controller.dto.request.LikeRequestDTO;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayLike;

public interface LikeService {
    EssayLike insertLike(LikeRequestDTO.insertLike request, Long essayId);
}
