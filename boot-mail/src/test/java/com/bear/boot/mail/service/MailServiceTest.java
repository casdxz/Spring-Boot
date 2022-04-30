package com.bear.boot.mail.service;

import com.bear.boot.mail.entity.Article;
import freemarker.template.Template;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.*;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-25 16:00
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class MailServiceTest {

    @Resource
    MailService mailService;

    @Resource
    FreeMarkerConfigurer freeMarkerConfigurer;

    @Test
    void sendSimpleMail() {
        mailService.sendSimpleMail("2210200908@qq.com",
                "普通文本邮件",
                "普通文本邮件内容测试");
    }

    @Test
    public void sendHtmlMail() throws MessagingException {
        mailService.sendHtmlMail(
                "2210200908@qq.com","一封来自金帅的邮件","""
                        <body>
                            <div style="width:600px;height:400px;margin:auto;background:#1abc9c;color:#fff;text-align:center;">
                                <h3>金帅</h3>
                                <img style="width:30vmin;height:30vmin;object-fit:cover;object-position:center;border-radius:50%" src="https://bearcad.oss-cn-shanghai.aliyuncs.com/%E5%A4%B4%E5%83%8F/%E5%8A%A8%E6%80%81%E5%A4%B4%E5%83%8F/avatar12.gif">
                                <P>
                                    <a style="text-decoration: none;color:#FFF;" href="" target="_bank" >
                                    <strong>我的博客主页</strong>
                                    </a>
                                </p>
                            </div>
                        </body>
                    """
        );

    }
    @Test
    public void sendTemplateMail() throws Exception {
        // 添加动态数据，替换模版里面的占位符
        List<Article> articles = new ArrayList<>();
        articles.add(new Article(1L, "bear", "今天星期一", "内容一", new Date()));
        articles.add(new Article(2L, "bear", "今天下雨天", "内容二", new Date()));
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("freemarker-temp.ftl");
        //将模版文件及数据渲染完成后，转换为html字符串
        Map<String, Object> model = new HashMap<>();
        model.put("articles", articles);
        String templateHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        // 发送邮件
        mailService.sendHtmlMail("2210200908@qq.com", "这是一封freemarker模版的html测试邮件",templateHtml);
    }

    @Test
    public void sendAttachmentsMailTest() throws MessagingException {
        String filePath = "D:\\03.png";
        mailService.sendAttachmentsMail(
                "169977349@qq.com",
                "这是一封带附件的邮件--来自bear",
                "邮件中有附件，请注意查收!",
                filePath);
    }

    @Test
    public void sendResourceMail() throws MessagingException {
        String rscId = "bear";
        String content = "<html><body>这是有图片的邮件<br/><img src='cid:" + rscId + "'></body></html>";
        String imgPath = "D:\\03.png";
        mailService.sendResourceMail(
                "2210200908@qq.com",
                "这邮件中包含图片",
                content,
                imgPath,
                rscId);
    }

}