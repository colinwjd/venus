package com.colinwjd.venus.commons.enums;

/**
 * 配置枚举
 *
 * @author Colin Wang
 * @date 2018/8/20
 */
public enum OptionEnum {

    /**
     * 博客标题
     */
    BLOG_TITLE("blog_title"),

    /**
     * 博客地址
     */
    BLOG_URL("blog_url"),

    /**
     * 文章摘要字数
     */
    SUMMARY_WORD_COUNT("summary_word_count"),

    /**
     * 首页文章数量
     */
    INDEX_POST_NUM("index_post_num"),

    /**
     * 是否已经安装
     */
    IS_INSTALL("is_install"),

    /**
     * RSS显示文章条数
     */
    RSS_POST_NUM("rss_post_num"),

    /**
     * API状态
     */
    API_STATUS("api_status"),

    /**
     * 邮箱服务器地址
     */
    MAIL_SMTP_HOST("mail_smtp_host"),

    /**
     * 邮箱地址
     */
    MAIL_SMTP_USERNAME("mail_smtp_username"),

    /**
     * 邮箱密码／授权码
     */
    MAIL_SMTP_PASSWORD("mail_smtp_password"),

    /**
     * 发送者名称
     */
    MAIL_FROM_NAME("mail_from_name"),

    /**
     * 启用邮件服务
     */
    SMTP_EMAIL_ENABLE("smtp_email_enable"),

    /**
     * 邮件回复通知
     */
    COMMENT_REPLY_NOTICE("comment_reply_notice"),

    /**
     * 新评论是否需要审核
     */
    NEW_COMMENT_NEED_CHECK("new_comment_need_check"),

    /**
     * 新评论通知
     */
    NEW_COMMENT_NOTICE("new_comment_notice"),

    /**
     * 邮件审核通过通知
     */
    COMMENT_PASS_NOTICE("comment_pass_notice"),

    /**
     * 站点描述
     */
    SEO_DESC("seo_desc"),

    /**
     * 博客主题
     */
    THEME("theme"),

    /**
     * 博客创建日期
     */
    BLOG_CREATE_DATE("blog_create_date"),

    /**
     * 博客评论系统
     */
    COMMENT_SYSTEM("comment_system"),

    /**
     * 仪表盘部件 文章总数
     */
    WIDGET_POST_COUNT("widget_post_count"),

    /**
     * 仪表盘部件 评论总数
     */
    WIDGET_COMMENT_COUNT("widget_comment_count"),

    /**
     * 仪表盘部件 创建天数
     */
    WIDGET_DAY_COUNT("widget_day_count");

    private String value;

    OptionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
