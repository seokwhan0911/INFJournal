package com.um5th.hackerthon.infjournal.repository;

import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface EssayLikeRepository extends JpaRepository<EssayLike, Long> {
    Optional<EssayLike> findByMemberAndEssay(Member member, Essay essay);

    void deleteByMemberAndEssay(Member member, Essay essay);
}
