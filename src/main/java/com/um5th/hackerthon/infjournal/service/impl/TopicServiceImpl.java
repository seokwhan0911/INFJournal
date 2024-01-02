package com.um5th.hackerthon.infjournal.service.impl;

import com.um5th.hackerthon.infjournal.domain.Topic;
import com.um5th.hackerthon.infjournal.repository.TopicRepository;
import com.um5th.hackerthon.infjournal.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    @Autowired
    private final TopicRepository topicRepository;

    @Override
    public Boolean isTopicExist(Long id) {
        return topicRepository.existsById(id);
    }

}
