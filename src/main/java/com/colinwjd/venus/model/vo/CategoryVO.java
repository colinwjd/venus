package com.colinwjd.venus.model.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.colinwjd.venus.model.entity.Category;
import lombok.Builder;
import lombok.Data;

/**
 * 类目 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@Data
@Builder
public class CategoryVO implements Serializable {

    private static final long serialVersionUID = 71919791957245046L;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 类目说明
     */
    private String desc;

    /**
     * 类目地址
     */
    private String url;

    public static CategoryVO buildWith(Category category) {
        return category == null ? null : CategoryVO.builder()
            .name(category.getName())
            .desc(category.getDesc())
            .url(category.getUrl())
            .build();
    }

    public static List<CategoryVO> buildWith(Iterable<Category> categories) {
        if (categories == null) {
            return null;
        }
        List<CategoryVO> result = new ArrayList<>();
        categories.forEach(category -> result.add(buildWith(category)));
        return result;
    }
}
