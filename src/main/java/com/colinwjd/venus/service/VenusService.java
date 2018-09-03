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

    void sendSimpleEmail(String to, String subject, String content);

    void sendHtmlEmail(String to, String subject, String content);

    void sendAttachmentsEmail(String to, String subject, String content, String filePath);

    void sendInlineResEmail(String to, String subject, String content, String resPath, String resId);

    void venusBackup();
}
