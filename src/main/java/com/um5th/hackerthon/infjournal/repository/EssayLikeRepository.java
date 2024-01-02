package com.um5th.hackerthon.infjournal.repository;

import com.um5th.hackerthon.infjournal.domain.Essay;
import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.EssayLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface EssayLikeRepository extends JpaRepository<EssayLike, Long> {
    Optional<EssayLike> findByMemberAndEssay(Member member, Essay essay);

    void deleteByMemberAndEssay(Member member, Essay essay);

    //Integer countByEssay(Long essayId);
    @Query("SELECT COUNT(e) FROM EssayLike e WHERE e.essay = :essay")
    Integer countByEssay(@Param("essay") Essay essay);
}
