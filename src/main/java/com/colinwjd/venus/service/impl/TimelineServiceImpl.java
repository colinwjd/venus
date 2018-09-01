package com.colinwjd.venus.service.impl;

import com.colinwjd.venus.model.entity.Timeline;
import com.colinwjd.venus.repository.TimelineRepository;
import com.colinwjd.venus.service.TimelineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 时间轴服务实现
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
@Slf4j
@Service
public class TimelineServiceImpl implements TimelineService {

    private final TimelineRepository timelineRepository;

    @Autowired
    public TimelineServiceImpl(TimelineRepository timelineRepository) {
        this.timelineRepository = timelineRepository;
    }

    @Override
    public Timeline saveByTimeline(Timeline timeline) {
        return timelineRepository.save(timeline);
    }

    @Override
    public Timeline removeById(Long id) {
        Optional<Timeline> timeline = timelineRepository.findById(id);
        if (timeline.isPresent()) {
            timelineRepository.deleteById(id);
            log.debug("Timeline deleted: " + timeline.get().getTitle());
        }
        return timeline.orElse(null);
    }

    @Override
    public List<Timeline> findAll() {
        return timelineRepository.findAll();
    }

    @Override
    public Page<Timeline> findAll(Pageable pageable) {
        return timelineRepository.findAll(pageable);
    }

    @Override
    public List<Timeline> findLatestN(int n) {
        return timelineRepository.findLatestN(n);
    }

    @Override
    public Timeline findById(Long id) {
        return timelineRepository.findById(id).orElse(null);
    }
}
