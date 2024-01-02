package com.um5th.hackerthon.infjournal.repository;

import com.um5th.hackerthon.infjournal.domain.mapping.EssayLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EssayLikeRepository extends JpaRepository<EssayLike, Long> {
}
