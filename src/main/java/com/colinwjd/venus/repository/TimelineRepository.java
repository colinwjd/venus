package com.colinwjd.venus.repository;

import com.colinwjd.venus.model.entity.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 时间轴数据访问接口
 *
 * @author Colin Wang
 * @date 2018/8/22
 */
public interface TimelineRepository extends JpaRepository<Timeline, Long> {

    /**
     * 查询最新的N条事件
     *
     * @param n 数量
     * @return 事件列表
     */
    @Query(value = "select * from venus_timeline order by event_time desc limit ?1", nativeQuery = true)
    List<Timeline> findLatestN(int n);
}
