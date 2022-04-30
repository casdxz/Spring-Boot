package com.bear.boot.code.controller;

import com.bear.boot.code.utils.MathCodeUtil;
import com.bear.boot.code.utils.RandomCodeUtil;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-29 09:31
 **/
@RestController
@Slf4j
public class ValidateCodeController {
    @Resource
    private RandomCodeUtil randomCodeUtil;

    @Resource
    private MathCodeUtil mathCodeUtil;

    @Resource
    private Producer producer;

    @Resource
    private HttpServletRequest request;

    @Resource
    private HttpServletResponse response;

    @GetMapping("/randomCode")
    private void randomCode() {
        try {
            randomCodeUtil.createCode(request,response);
        }catch (IOException e) {
            log.error("生成验证码错误");
        }
    }

    @GetMapping("/checkRandomCode")
    private String checkRandomCode(String code) {
        String saveCode = (String) request.getSession().getAttribute("randomCode");
        log.info(saveCode);
        if (saveCode.equalsIgnoreCase(code)){
            log.info("验证码正确");
            return "验证码正确";
        }else {
            log.info("验证码错误");
            return "验证码错误";
        }
    }

    @GetMapping("/mathCode")
    private void mathCode() {
        try {
            mathCodeUtil.createCode(request,response);
        }catch (IOException e) {
            log.error("生成验证码错误");
        }
    }

    @GetMapping("/checkMathCode")
    private String checkMathCode(String code) {
        int saveCode = (Integer) request.getSession().getAttribute("mathCode");
        log.info(String.valueOf(saveCode));
        int sendCode = Integer.parseInt(code);
        if (saveCode == sendCode){
            log.info("验证码正确");
            return "验证码正确";
        }else {
            log.info("验证码错误");
            return "验证码错误";
        }
    }

    @GetMapping("/captchaCode")
    private void captchaCode() {
        response.setHeader("Cache-Control","no-store");
        response.setContentType("image/jpeg");

        String text = producer.createText();
        log.info(text);
        request.getSession().setAttribute("captchaCode",text);

        BufferedImage image = producer.createImage(text);

        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,text);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            ImageIO.write(image,"jpg", outputStream);
        }catch (IOException e) {
            log.error("生成验证码错误");
        }
        IOUtils.closeQuietly(outputStream);
    }

    @GetMapping("/checkCaptchaCode")
    private String checkCaptchaCode(String code) {
        String saveCode = (String) request.getSession().getAttribute("captchaCode");
        log.info(saveCode);
        if (saveCode.equalsIgnoreCase(code)){
            log.info("验证码正确");
            return "验证码正确";
        }else {
            log.info("验证码错误");
            return "验证码错误";
        }
    }
}
