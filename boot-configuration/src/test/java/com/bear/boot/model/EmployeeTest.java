package com.bear.boot.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-14 15:47
 **/
@Slf4j
@ExtendWith(SpringExtension.class) //JUnit5
@SpringBootTest
class EmployeeTest {
    @Resource
    private Employee employee;

    @Test
    void valueBind() throws Exception{
        log.info(String.valueOf(employee));
        //Map<String, Integer> map = employee.getEmployeeAge();
        //
        //map.forEach((key,value) -> System.out.println(key + "->" + value));

    }

    @Test
    public void testList() {
        List<String> list = List.of("bbb","bear","aaa");
        list.forEach(str -> System.out.println(str));

        list.forEach(System.out::println);
    }
}