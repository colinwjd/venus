package com.colinwjd.venus.model.vo;

import com.colinwjd.venus.model.entity.Category;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 类目 视图对象
 *
 * @author Colin Wang
 * @date 2018/9/7
 */
@Data
@Builder
public class CategoryVO {

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
        return CategoryVO.builder()
                .name(category.getName())
                .desc(category.getDesc())
                .url(category.getUrl())
                .build();
    }

    public static List<CategoryVO> buildWith(Collection<Category> categories) {
        if (categories == null) return null;
        List<CategoryVO> result = new ArrayList<>(categories.size());
        categories.forEach(category -> result.add(buildWith(category)));
        return result;
    }
}
