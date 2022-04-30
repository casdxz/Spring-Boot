package com.bear.boot.jpa.repository;

import com.bear.boot.jpa.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-19 09:18
 **/
public interface PeopleRepository extends JpaRepository<People,Integer> {

    // find,read,get

    /**
     * find,read,get
     * 查找全部
     * @return
     */
    @Override
    List<People> findAll();

    /**
     *  根据firstName查找
     * @param firstName
     * @return
     */
    List<People> findByFirstName(String firstName);

    /*
    // 根据firstName和lastName查找(两者必须在数据库有)
    People findByFirstNameAndLastName(String firstName, String lastName);

    // 根据firstName或lastName查找(两者其一有就行)
    People findByLastNameOrFirstName(String lastName, String firstName);

    // 根据firstName查找它是否存在数据库里
    People findByFirstNameIs(String firstName);

    // 根据firstName查找它是否存在数据库里
    People findByFirstNameEquals(String firstName);

     */
}
