package com.colinwjd.venus.service.impl;

import com.colinwjd.venus.model.entity.Gallery;
import com.colinwjd.venus.repository.GalleryRepository;
import com.colinwjd.venus.service.GalleryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 图库服务实现
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
@Slf4j
@Service
public class GalleryServiceImpl implements GalleryService {

    private final GalleryRepository galleryRepository;

    @Autowired
    public GalleryServiceImpl(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    @Override
    public Gallery saveByGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    @Override
    public Gallery removeById(Long id) {
        Optional<Gallery> gallery = galleryRepository.findById(id);
        if (gallery.isPresent()) {
            galleryRepository.deleteById(id);
            log.debug("Gallery deleted: " + gallery.get().getName());
        }
        return gallery.orElse(null);
    }

    @Override
    public List<Gallery> findAll() {
        return galleryRepository.findAll();
    }

    @Override
    public Page<Gallery> findAll(Pageable pageable) {
        return galleryRepository.findAll(pageable);
    }

    @Override
    public Gallery findById(Long id) {
        return galleryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Gallery> findLatestN(int n) {
        return galleryRepository.findLatestN(n);
    }
}
