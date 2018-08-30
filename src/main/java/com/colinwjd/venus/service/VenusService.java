package com.colinwjd.venus.service;

/**
 * Venus 服务
 *
 * @author Colin Wang
 * @date 2018/8/28
 */
public interface VenusService {

    /**
     * 生成RSS
     *
     * @return RSS字符串
     */
    String generateRss();

    /**
     * 生成SiteMap
     *
     * @return SiteMap字符串
     */
    String generateSiteMap();
}
