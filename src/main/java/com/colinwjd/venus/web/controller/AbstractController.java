package com.colinwjd.venus.web.controller;

import org.springframework.boot.web.servlet.error.ErrorController;

/**
 * 抽象控制器
 *
 * @author Colin Wang
 * @date 2018/9/15
 */
public abstract class AbstractController implements ErrorController {

    protected static String THEME = "default";

    private static String ERROR_PATH = "/error";

    /**
     * 主题渲染
     *
     * @param name 视图名称
     * @return 主题对应的视图
     */
    protected String render(String name) {
        return "themes/" + THEME + "/" + name;
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
