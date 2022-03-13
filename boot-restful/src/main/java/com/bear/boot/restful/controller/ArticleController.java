package com.bear.boot.restful.controller;

import com.bear.boot.restful.common.AjaxResponse;
import com.bear.boot.restful.model.Article;
import com.bear.boot.restful.model.Reader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-10 16:30
 **/
@RestController
@Slf4j
@RequestMapping("/api/v1/articles")
public class ArticleController {

    /**
     * 获取一篇Article，使用GET方法,根据id查询一篇文章
     *
     * @param id id
     * @return AjaxResponse
     */
    //@RequestMapping(value = "/articles/{id}",method = RequestMethod.GET)
    @GetMapping("/{id}")
    public AjaxResponse getArticle(@PathVariable("id") Long id) {
        //Reader[] readers = {
        //        Reader.builder().name().age(),
        //        Reader.builder().name().age().build()
        //};
        List<Reader> readerList = List.of(Reader.builder().name("bear").age(20).build(),Reader.builder().name("bear1").age(25).build());

        Article article = Article.builder()
                .id(id)
                .author("bear")
                .content("SpringBoot 从青铜到王者")
                .title("SpringBoot")
                .readerList(readerList)
                .createTime(new Date())
                .updateTime(new Date())
                .build();
        log.info("article:" + article);
        return AjaxResponse.success(article);
    }


    @GetMapping()
    public AjaxResponse getArticleByParam(@RequestParam("idd") long id) {
        List<Reader> readerList = List.of(Reader.builder().name("aaa").age(12).build(), Reader.builder().name("bbb").age(13).build());
        Article article = Article.builder()
                .id(id)
                .author("radical")
                .content("SpringBoot 从青铜到王者")
                .title("SpringBoot")
                .readerList(readerList)
                .createTime(new Date()).build();
        log.info("article:" + article);
        return AjaxResponse.success(article);
    }

    @GetMapping("all")
    public AjaxResponse selectAll() {
        List<Reader> readerList = List.of(Reader.builder().name("bear1").age(20).build(), Reader.builder().name("bear2").age(25).build());
        Article article = Article.builder()
                .id(111L)
                .author("bear")
                .content("SpringBoot")
                .title("SpringBoot")
                .readerList(readerList)
                .createTime(new Date())
                .build();
        Article article2 = Article.builder()
                .id(222L)
                .author("bear")
                .content("Java")
                .title("Java")
                .readerList(readerList)
                .createTime(new Date())
                .build();
        return AjaxResponse.success(List.of(article, article2));
    }

    /**
     * 增加一篇Article ，使用POST方法(RequestBody方式接收参数)
     *
     * @param article article
     * @return AjaxResponse
     */
    @PostMapping("body")
    public AjaxResponse saveArticleByJsonBody(@RequestBody Article article) {
        log.info("saveArticle:" + article);
        return AjaxResponse.success(article);
    }

    //@PostMapping("/articles")
    //public AjaxResponse saveArticle(@RequestBody Article article, @RequestHeader String aaa) {
    //    log.info("saveArticle:" + article);
    //    log.info("请求头aaa:" + aaa);
    //    return AjaxResponse.success(article);
    //}

    /**
     * 增加一篇Article ，使用POST方法(RequestParam方式接收参数
     *
     * @param author     author
     * @param title      title
     * @param content    content
     * @param createTime createTime
     * @return AjaxResponse
     */
    @PostMapping("param")
    public AjaxResponse saveArticleByParams(
            @RequestParam long id,
            @RequestParam(value = "author", defaultValue = "radical", required = false) String author,
            @RequestParam String title,
            @RequestParam String content,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @RequestParam Date createTime) {
        Article article = Article.builder()
                .id(id)
                .title(title)
                .author(author)
                .content(content)
                .createTime(createTime)
                .build();
        return AjaxResponse.success(article);
    }

    @PostMapping("form")
    public AjaxResponse saveArticleByFormData(@RequestParam("formData") String formData) {
        log.info("formData: " + formData);
        // 用Jackson反序列化将字符串转为Java对象
        ObjectMapper mapper = new ObjectMapper();
        Article article = null;
        try {
            article = mapper.readValue(formData, Article.class);
            log.info("article: " + article);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return AjaxResponse.success(article);
    }

    //@PostMapping("/articles")
    //public AjaxResponse saveArticle(@RequestParam String author, @RequestParam String title, @RequestParam String content, @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam Date createTime) {
    //    log.info("saveArticle:" + author);
    //    log.info("saveArticle:" + title);
    //    log.info("saveArticle:" + content);
    //    log.info("saveArticle:" + createTime);
    //    return AjaxResponse.success();
    //}

    /**
     * 更新一篇Article，使用PUT方法，以id为主键进行更新
     *
     * @param article article
     * @return AjaxResponse
     */
    @PutMapping("/articles")
    public AjaxResponse updateArticle(@RequestBody Article article) {
        if (article.getId() == null) {
            log.error("没有id");
            //article.id是必传参数，因为通常根据id去修改数据
        }
        log.info("updateArticle:" + article);
        return AjaxResponse.success();
    }

    /**
     * 删除一篇Article，使用DELETE方法，参数是id
     *
     * @param id id
     * @return AjaxResponse
     */
    @DeleteMapping("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable("id") Long id) {
        log.info("deleteArticle:" + id);
        return AjaxResponse.success();
    }

    //@GetMapping("/article/{id}")
    //public AjaxResponse getArticle(@PathVariable("id") Long id){
    //    Article article = Article.builder()
    //            .id(id)
    //            .author("bear")
    //            .title("SpringBoot")
    //            .content("SpringBoot从青铜到王者")
    //            .createTime(new Date())
    //            .updateTime(new Date())
    //            .build();
    //    return AjaxResponse.success(article);
    //}

    //@PostMapping("/articles")
    //public AjaxResponse saveArticle(@RequestBody Article article){
    //    log.info("saveArticle" + article);
    //    return AjaxResponse.success(article);
    //}
    //@PutMapping("/articles")
    //public AjaxResponse updateArticle(@RequestBody Article article){
    //    log.info("updateArticle" + article);
    //    return AjaxResponse.success(article);
    //}

    //@DeleteMapping("/articles")
    //public AjaxResponse deleteArticle(@RequestBody Long id){
    //    log.info("删除文章的id为" + id);
    //    return AjaxResponse.success();
    //}
}
