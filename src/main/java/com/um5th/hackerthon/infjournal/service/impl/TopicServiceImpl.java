package com.um5th.hackerthon.infjournal.service.impl;

import com.um5th.hackerthon.infjournal.domain.Member;
import com.um5th.hackerthon.infjournal.domain.Topic;
import com.um5th.hackerthon.infjournal.domain.mapping.TodayTopic;
import com.um5th.hackerthon.infjournal.repository.EssayRepository;
import com.um5th.hackerthon.infjournal.repository.TodayTopicRepository;
import com.um5th.hackerthon.infjournal.repository.TopicRepository;
import com.um5th.hackerthon.infjournal.service.TopicService;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;
    private final TodayTopicRepository todayTopicRepository;
    private final EssayRepository essayRepository;

    @Override
    public Boolean isTopicExist(Long id) {
        return topicRepository.existsById(id);
    }

    @Override
    @Transactional
    public TodayTopic getTodayTopic(Member member) {
        TodayTopic todayTopic = todayTopicRepository.findByMember(member).get();

        if (todayTopic.getTopic() != null) {
            return todayTopic;
        }

        List<Long> writtenTopicIdList = essayRepository.findAllByMember(member)
                                                       .stream()
                                                       .map(essay -> essay.getTopic().getId())
                                                       .toList();

        Long totalTopicCount = topicRepository.count();
        Topic randomTopic = getRandomTopic(new Random(), writtenTopicIdList, totalTopicCount);

        todayTopic.setTopic(randomTopic);

        return todayTopic;
    }

    private Topic getRandomTopic(Random random, List<Long> writtenTopicIdList, Long totalTopicCount) {
        Long randomTopicId = random.nextLong(totalTopicCount);
        if (writtenTopicIdList.stream().anyMatch(topicId -> topicId.equals(randomTopicId))) {
            return getRandomTopic(random, writtenTopicIdList, totalTopicCount);
        }
        return topicRepository.findById(randomTopicId).get();
    }
}
