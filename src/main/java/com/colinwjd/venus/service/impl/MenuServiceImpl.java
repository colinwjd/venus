package com.colinwjd.venus.service.impl;

import com.colinwjd.venus.model.entity.Menu;
import com.colinwjd.venus.repository.MenuRepository;
import com.colinwjd.venus.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 菜单服务实现
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu saveByMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu removeById(Long id) {
        Optional<Menu> menu = menuRepository.findById(id);
        if (menu.isPresent()) {
            menuRepository.deleteById(id);
            log.debug("Menu deleted: " + menu.get().getName());
        }
        return menu.orElse(null);
    }

    @Override
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public Menu findById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    @Override
    public Menu findByUrl(String url) {
        return menuRepository.findByUrl(url);
    }

    @Override
    public Menu findByName(String name) {
        return menuRepository.findByName(name);
    }
}
