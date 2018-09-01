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

    Gallery saveByGallery(Gallery gallery);

    Gallery removeById(Long id);

    List<Gallery> findAll();

    Page<Gallery> findAll(Pageable pageable);

    Gallery findById(Long id);

    List<Gallery> findLatestN(int n);
}
