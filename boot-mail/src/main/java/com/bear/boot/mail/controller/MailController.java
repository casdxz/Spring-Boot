package com.bear.boot.mail.controller;

import com.bear.boot.mail.common.AjaxResponse;
import com.bear.boot.mail.entity.Article;
import com.bear.boot.mail.service.MailService;
import freemarker.template.Template;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-25 23:39
 **/
public class MailController {

    @Resource
    MailService mailService;

    @Resource
    FreeMarkerConfigurer freeMarkerConfigurer;

    @PostMapping("/register")
    public AjaxResponse register(@RequestBody Article article) throws Exception {
        List<Article> articles = new ArrayList<>();
        articles.add(article);
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("freemarker-temp.ftl");
        //将模版文件及数据渲染完成后，转换为html字符串
        Map<String, Object> model = new HashMap<>();
        model.put("articles", articles);
        String templateHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        mailService.sendHtmlMail("ethanjiao@foxmail.com", "这是一封来自EthanJiao基于freemarker模版的html测试邮件", templateHtml);
        return AjaxResponse.success("注册成功，请前往邮箱激活用户！");
    }
}
