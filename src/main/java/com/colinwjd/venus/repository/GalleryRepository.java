package com.colinwjd.venus.repository;

import com.colinwjd.venus.model.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 图库数据访问接口
 *
 * @author Colin Wang
 * @date 2018/8/22
 */
public interface GalleryRepository extends JpaRepository<Gallery, Long> {

    /**
     * 查询最新的N个图片
     *
     * @param n 数量
     * @return 图片列表
     */
    @Query(value = "select * from venus_gallery order by create_time desc limit ?1", nativeQuery = true)
    List<Gallery> findLastestN(int n);
}
