package com.colinwjd.venus.web.controller.api;

import com.colinwjd.venus.common.enums.OptionEnum;
import com.colinwjd.venus.model.bo.JsonResp;
import com.colinwjd.venus.model.entity.Option;
import com.colinwjd.venus.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 配置项 API
 *
 * @author Colin Wang
 * @date 2018/9/6
 */
@RestController
@RequestMapping("/api/option")
public class OptionApiController {

    private final OptionService optionService;

    @Autowired
    public OptionApiController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("/all")
    public JsonResp<Map<String, String>> findAll() {
        Map<String, String> options = optionService.findAll();
        options.remove(OptionEnum.MAIL_SMTP_HOST.getValue());
        options.remove(OptionEnum.MAIL_FROM_NAME.getValue());
        options.remove(OptionEnum.MAIL_SMTP_USERNAME.getValue());
        options.remove(OptionEnum.MAIL_SMTP_PASSWORD.getValue());
        return options.isEmpty() ? JsonResp.httpStatus(HttpStatus.NO_CONTENT) : JsonResp.success(options);
    }

    @GetMapping("/{name}")
    public JsonResp<String> findByName(String name) {
        Option option = optionService.findByName(name);
        return option == null ? JsonResp.httpStatus(HttpStatus.NOT_FOUND) : JsonResp.success(option.getValue());
    }
}
