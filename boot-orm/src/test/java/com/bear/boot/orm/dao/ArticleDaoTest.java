package com.bear.boot.orm.dao;

import com.bear.boot.orm.entity.Article;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-18 15:16
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
class ArticleDaoTest {
    @Resource
    private ArticleDao articleDao;

    @Test
    void save () {
            Article article = Article.builder()
                .id(1000)
                .author("bear")
                .title("SpringBoot")
                .content("SpringBoot从入门到入土")
                .createTime(new Date())
                .build();
        articleDao.save(article);
    }
}