package com.colinwjd.venus.web.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 抽象控制器
 *
 * @author Colin Wang
 * @date 2018/9/15
 */
public abstract class AbstractController implements ErrorController {

    protected static String THEME = "default";

    private static final String ERROR_PATH = "/error";

    /**
     * 主题模板路径渲染
     *
     * @param name 视图名称
     * @return 主题对应的视图
     */
    protected String render(String name) {
        return "themes/" + THEME + "/" + name;
    }

    @RequestMapping(ERROR_PATH)
    public String errorHandler(HttpServletRequest request, HttpServletResponse response) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        switch (statusCode) {
            case 404:
                return this.render("404");
            default:
                return this.render("500");
        }
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
