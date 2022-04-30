package com.bear.boot.template.controller;

import com.bear.boot.template.entity.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-04 18:42
 **/
@Controller
@RequestMapping("/template")
public class TemplateController {

    @GetMapping("/freemarker")
    public String freemarkerIndex(Model model) {
        List<Article> articles = Arrays.asList(
                new Article(1, "张三", "Java"),
                new Article(2, "张三丰", "Spring"),
                new Article(3, "张三风", "SpringBoot")
        );
        model.addAttribute("articles", articles);
        System.out.println(articles);
        // 模版名称，实际的目录为:resources/templates/freemarker-demo.ftl
        return "freemarker-demo";
    }

    @GetMapping("/thymeleaf")
    public String thymeleafIndex(Model model) {
        List<Article> articles = Arrays.asList(
                new Article(1, "张三", "Java"),
                new Article(2, "张三丰", "Spring"),
                new Article(3, "张三风", "SpringBoot")
        );
        model.addAttribute("articles", articles);
        return "thymeleaf-demo";
    }
}
