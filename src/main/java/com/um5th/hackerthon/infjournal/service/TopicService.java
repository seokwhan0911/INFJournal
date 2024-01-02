package com.um5th.hackerthon.infjournal.service;

import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.mapping.TodayTopic;

public interface TopicService {

    Boolean isTopicExist(Long id);

    TodayTopic getTodayTopic(Member member);
}
