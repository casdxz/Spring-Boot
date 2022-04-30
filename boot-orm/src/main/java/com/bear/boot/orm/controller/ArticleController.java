package com.bear.boot.orm.controller;

import com.bear.boot.orm.common.AjaxResponse;
import com.bear.boot.orm.service.impl.ArticleJpaServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-18 15:56
 **/
@RestController
@RequestMapping(value = "/api/v1/articles")
public class ArticleController {

    @Resource
    private ArticleJpaServiceImpl articleJpaService;

    @GetMapping(value = "/all")
    public AjaxResponse selectAll(){
        return AjaxResponse.success(articleJpaService.selectAll());
    }

    //@PostMapping()
    //public AjaxResponse addArticle(@RequestBody Article article) {
    //    return AjaxResponse.success(articleJpaService.saveArticle(article));
    //}

    //@PutMapping()
    //public AjaxResponse addArticle(@RequestBody Article article){
    //    if (articleJpaService.saveArticle(article) != null){
    //        return AjaxResponse.success("修改成功");
    //    }else {
    //        return AjaxResponse.failure();
    //    }
    //}

    @GetMapping("{id}")
    public AjaxResponse findById(@PathVariable int id){
        return AjaxResponse.success(articleJpaService.findById(id));
    }
}
