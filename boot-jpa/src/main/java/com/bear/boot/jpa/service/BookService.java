package com.bear.boot.jpa.service;

import com.bear.boot.jpa.entity.Book;
import org.springframework.data.domain.Page;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-19 09:49
 **/
public interface BookService {
    /**
     *  不带条件查询
     * @param page
     * @param size
     * @return Page<Book>
     */
    Page<Book> findBookNoCriteria(Integer page,Integer size);

    /**
     *  不带条件查询
     * @param page
     * @param size
     * @param book
     * @return Page<Book>
     */
    Page<Book> findBookCriteria(Integer page,Integer size,Book book);
}
