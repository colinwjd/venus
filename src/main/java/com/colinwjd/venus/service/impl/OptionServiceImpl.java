package com.colinwjd.venus.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.colinwjd.venus.model.entity.Option;
import com.colinwjd.venus.repository.OptionRepository;
import com.colinwjd.venus.service.OptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 配置项服务实现
 *
 * @author Colin Wang
 * @date 2018/9/1
 */
@Slf4j
@Service
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;

    @Autowired
    public OptionServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public Option saveByOption(Option option) {
        return optionRepository.save(option);
    }

    @Override
    public Option saveOption(String name, String value) {
        Option option = optionRepository.findByName(name);
        if (option != null) {
            option.setValue(value);
        } else {
            option = new Option();
            option.setName(name);
            option.setValue(value);

        }
        return optionRepository.save(option);
    }

    @Override
    public void saveOptions(Map<String, String> options) {
        if (options != null && !options.isEmpty()) {
            options.forEach(this::saveOption);
        }
    }

    @Override
    public Option removeById(Long id) {
        Optional<Option> option = optionRepository.findById(id);
        if (option.isPresent()) {
            optionRepository.deleteById(id);
            log.debug("Option deleted: " + option.get().getName());
        }
        return option.orElse(null);
    }

    @Override
    public Map<String, String> findAll() {
        List<Option> options = optionRepository.findAll();
        Map<String, String> map = new HashMap<>(options.size());
        options.forEach(option -> map.put(option.getName(), option.getValue()));
        return map;
    }

    @Override
    public Option findByName(String name) {
        return optionRepository.findByName(name);
    }
}
