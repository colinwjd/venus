package com.colinwjd.venus.service.impl;

import com.colinwjd.venus.model.entity.Event;
import com.colinwjd.venus.repository.EventRepository;
import com.colinwjd.venus.service.EventService;
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
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event saveByEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event removeById(Long id) {
        Optional<Event> timeline = eventRepository.findById(id);
        if (timeline.isPresent()) {
            eventRepository.deleteById(id);
            log.debug("Event deleted: " + timeline.get().getTitle());
        }
        return timeline.orElse(null);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Page<Event> findAll(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    @Override
    public List<Event> findLatestN(int n) {
        return eventRepository.findLatestN(n);
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }
}
