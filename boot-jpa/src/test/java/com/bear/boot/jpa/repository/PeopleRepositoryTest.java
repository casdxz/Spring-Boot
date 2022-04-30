package com.bear.boot.jpa.repository;

import com.bear.boot.jpa.entity.People;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-19 12:07
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class PeopleRepositoryTest {

    @Resource
    private PeopleRepository peopleRepository;

    @Test
    public void findAll() {
        List<People> peopleList = peopleRepository.findAll();
        assertEquals(2,peopleList.size());
    }

    @Test
    public void findByFirstName() {
        List<People>peopleList=peopleRepository.findByFirstName("jin");
        assertEquals(2,peopleList.size());

    }
}