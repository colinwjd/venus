package com.colinwjd.venus.service.impl;

import com.colinwjd.venus.model.entity.Category;
import com.colinwjd.venus.repository.CategoryRepository;
import com.colinwjd.venus.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 类目服务实现
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveByCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category removeById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.deleteById(id);
            log.debug("Category deleted: " + category.get().getName());
        }
        return category.orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category findByUrl(String url) {
        return categoryRepository.findByUrl(url);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
