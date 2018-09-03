package com.colinwjd.venus.service;

import com.colinwjd.venus.model.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 时间轴(事件)服务
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
public interface EventService {

    /**
     * 保存事件
     *
     * @param event 事件
     * @return 事件
     */
    Event saveByEvent(Event event);

    /**
     * 通过ID删除事件
     *
     * @param id 事件ID
     * @return 被删除的事件
     */
    Event removeById(Long id);

    /**
     * 查询所有事件
     *
     * @return 事件列表
     */
    List<Event> findAll();

    /**
     * 查询所有事件 分页
     *
     * @param pageable 分页信息
     * @return 事件分页
     */
    Page<Event> findAll(Pageable pageable);

    /**
     * 查询最新的N条事件
     *
     * @param n 数量
     * @return 事件列表
     */
    List<Event> findLatestN(int n);

    /**
     * 通过ID查询事件
     *
     * @param id 事件ID
     * @return 事件
     */
    Event findById(Long id);
}
