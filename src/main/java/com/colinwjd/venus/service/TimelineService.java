package com.colinwjd.venus.service;

import com.colinwjd.venus.model.entity.Timeline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 时间轴服务
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
public interface TimelineService {

    Timeline saveByTimeline(Timeline timeline);

    Timeline removeById(Long id);

    List<Timeline> findAll();

    Page<Timeline> findAll(Pageable pageable);

    List<Timeline> findLatestN(int n);

    Timeline findById(Long id);
}
