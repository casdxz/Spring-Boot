package com.bear.boot.orm.service;

import com.bear.boot.orm.entity.Article;

import java.util.List;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-18 09:22
 **/
public interface ArticleService {

    /**
     * 新增文章
     * @param article
     * @return
     */
    Article saveArticle(Article article);

    /**
     * 根据id删除文章
     * @param id
     */
    void deleteById(int id);

    /**
     *
     * @param article
     */
    void updateArticle(Article article);

    /**
     *
     * @return
     */
    List<Article> selectAll();

    /**
     *
     * @param id
     * @return
     */
    Article findById(int id);

    /**
     *
     * @param author
     * @return
     */
    List<Article> finByAuthor(String author);
}
