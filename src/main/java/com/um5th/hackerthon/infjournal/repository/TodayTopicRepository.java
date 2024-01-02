package com.um5th.hackerthon.infjournal.repository;

import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.TodayTopic;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodayTopicRepository extends JpaRepository<TodayTopic, Long> {

    Optional<TodayTopic> findByMember(Member member);
}
