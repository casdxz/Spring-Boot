package com.bear.boot.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-25 16:44
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class MailServiceTest {

    @Resource
    MailService mailService;

    @Test
    void sendSimpleMail() {
        mailService.sendSimpleMail("2210200908@qq.com",
                "普通文本邮件",
                "普通文本邮件内容测试");
    }

    @Test
    public void sendHtmlMail() throws MessagingException {
        mailService.sendHtmlMail(
                "16422802@qq.com","一封来自金帅的邮件","""
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

}