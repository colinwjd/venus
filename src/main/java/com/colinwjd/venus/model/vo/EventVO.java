package com.colinwjd.venus.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 事件 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@Data
public class EventVO {

    /**
     * 事件ID
     */
    private Long id;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 事件标题
     */
    private String title;

    /**
     * 事件内容
     */
    private String content;
}
