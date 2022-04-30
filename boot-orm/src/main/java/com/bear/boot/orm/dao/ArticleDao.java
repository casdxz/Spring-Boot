package com.bear.boot.orm.dao;

import com.bear.boot.orm.entity.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-18 09:02
 **/
@Repository
public class ArticleDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 新增文章
     *
     * @param article 入参
     */
    public void save(Article article) {
        String sql = "INSERT INTO article (author,title,content,create_time) VALUES(?,?,?,?) ";
        jdbcTemplate.update(sql, article.getAuthor(), article.getTitle(),
                article.getContent(), article.getCreateTime());
    }

    /**
     * 删除文章
     *
     * @param id 根据id
     */
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM article WHERE id = ? ", id);
    }


}