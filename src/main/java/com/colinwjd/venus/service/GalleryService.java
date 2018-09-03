package com.colinwjd.venus.service;

import com.colinwjd.venus.model.entity.Gallery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 图库服务
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
public interface GalleryService {

    /**
     * 保存图片
     *
     * @param gallery 图片
     * @return 图片
     */
    Gallery saveByGallery(Gallery gallery);

    /**
     * 通过ID删除图片
     *
     * @param id 图片ID
     * @return 被删除的图片
     */
    Gallery removeById(Long id);

    /**
     * 查询所有图片
     *
     * @return 图片列表
     */
    List<Gallery> findAll();

    /**
     * 查询所有图片 分页
     *
     * @param pageable 分页信息
     * @return 图片分页
     */
    Page<Gallery> findAll(Pageable pageable);

    /**
     * 通过ID查询图片
     *
     * @param id 图片ID
     * @return 图片
     */
    Gallery findById(Long id);

    /**
     * 查询最新的N张图片
     *
     * @param n 数量
     * @return 图片列表
     */
    List<Gallery> findLatestN(int n);
}
