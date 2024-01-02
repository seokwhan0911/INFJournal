package com.um5th.hackerthon.infjournal.service;

import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayLike;

public interface LikeService {
    EssayLike insertLike(Member member, Long essayId);
}
