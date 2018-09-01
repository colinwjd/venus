package com.colinwjd.venus.service;

import com.colinwjd.venus.model.entity.Category;

import java.util.List;

/**
 * 类目服务
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
public interface CategoryService {

    Category saveByCategory(Category category);

    Category removeById(Long id);

    List<Category> findAll();

    Category findById(Long id);

    Category findByUrl(String url);

    Category findByName(String name);
}
