package com.um5th.hackerthon.infjournal.repository;

import com.um5th.hackerthon.infjournal.domain.mapping.TodayTopic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodayTopicRepository extends JpaRepository<TodayTopic, Long> {
    
}
