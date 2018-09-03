package com.colinwjd.venus.service.impl;

import com.colinwjd.venus.service.VenusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Venus 服务实现
 *
 * @author Colin Wang
 * @date 2018/9/2
 */
@Slf4j
@Service
public class VenusServiceImpl implements VenusService {

    // TODO 邮件配置信息从系统配置项中获取，添加邮件模板，代码优化

    private final JavaMailSender mailSender;
    private String from;

    @Autowired
    public VenusServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public String generateRss() {
        // TODO
        return null;
    }

    @Override
    public String generateSiteMap() {
        // TODO
        return null;
    }

    @Override
    public void sendSimpleEmail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
        } catch (MailException e) {
            log.error("Send email error.", e);
        }
    }

    @Override
    public void sendHtmlEmail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            log.error("Send email error.", e);
        }
    }

    @Override
    public void sendAttachmentsEmail(String to, String subject, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            FileSystemResource file = new FileSystemResource(new File(filePath));
            helper.addAttachment(file.getFilename(), file);
            mailSender.send(message);
        } catch (MessagingException e) {
            log.error("Send email error.", e);
        }
    }

    @Override
    public void sendInlineResEmail(String to, String subject, String content, String resPath, String resId) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            FileSystemResource file = new FileSystemResource(new File(resPath));
            helper.addInline(resId, file);
            mailSender.send(message);
        } catch (MessagingException e) {
            log.error("Send email error.", e);
        }
    }

    @Override
    public void venusBackup() {
        // TODO
    }
}
