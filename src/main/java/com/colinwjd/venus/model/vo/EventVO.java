package com.colinwjd.venus.model.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.colinwjd.venus.model.entity.Event;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

/**
 * 事件 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@Data
@Builder
public class EventVO implements Serializable {

    private static final long serialVersionUID = -4666399889089477662L;

    /**
     * 事件ID
     */
    private Long id;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 事件标题
     */
    private String title;

    /**
     * 事件内容
     */
    private String content;

    public static EventVO buildWith(Event event) {
        return event == null ? null : EventVO.builder()
            .id(event.getId())
            .createTime(event.getCreateTime())
            .title(event.getTitle())
            .content(event.getContent())
            .build();
    }

    public static List<EventVO> buildWith(Iterable<Event> events) {
        if (events == null) {
            return null;
        }
        List<EventVO> result = new ArrayList<>();
        events.forEach(event -> result.add(buildWith(event)));
        return result;
    }
}
