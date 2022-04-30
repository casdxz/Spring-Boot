package com.bear.boot.orm.dao;

import com.bear.boot.orm.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-18 15:59
 **/
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    /**
     *
     * @param author
     * @return
     */
    List<Article> findByAuthor(String author);
}
