package com.bear.boot.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-14 12:00
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
class FamilyTest {

    @Autowired
    private Family family;

    @Test
    void printFamily() {
        System.out.println(family);
    }
}