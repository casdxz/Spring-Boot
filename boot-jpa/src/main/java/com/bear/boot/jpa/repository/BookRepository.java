package com.bear.boot.jpa.repository;

import com.bear.boot.jpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-19 09:18
 **/
public interface BookRepository extends JpaRepository<Book,Integer>, JpaSpecificationExecutor<Book> {

}
