package com.bear.boot.jpa.service.impl;

import com.bear.boot.jpa.entity.Book;
import com.bear.boot.jpa.repository.BookRepository;
import com.bear.boot.jpa.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-19 09:54
 **/
@Service
@Transactional(rollbackFor = {RuntimeException.class})
public class BookServiceImpl implements BookService {

    @Resource
    BookRepository bookRepository;

    @Override
    public Page<Book> findBookNoCriteria(Integer page,Integer size){
        Pageable pageable = PageRequest.of(page,size);
        return bookRepository.findAll(pageable);
    }

    @Override
    public Page<Book> findBookCriteria(Integer page,Integer size, final Book book){
        Pageable pageable = PageRequest.of(page,size, Sort.Direction.ASC,"id");
        Page<Book> bookPage = bookRepository.findAll(new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();

                if (null != book.getId()&&!"".equals(book.getId())){
                    list.add(criteriaBuilder.equal(root.get("id").as(String.class),book.getId()));
                }
                if (null != book.getName()&&!"".equals(book.getName())){
                    list.add(criteriaBuilder.equal(root.get("name").as(String.class),book.getName()));
                }
                if (null != book.getCover()&&!"".equals(book.getCover())){
                    list.add(criteriaBuilder.equal(root.get("cover").as(String.class),book.getCover()));
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        },pageable);
        return bookPage;
    }

}
