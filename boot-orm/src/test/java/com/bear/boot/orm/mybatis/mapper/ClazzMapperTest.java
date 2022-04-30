package com.bear.boot.orm.mybatis.mapper;

import com.bear.boot.orm.mybatis.domain.Clazz;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-28 22:54
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class ClazzMapperTest {

    @Resource
    private ClazzMapper clazzMapper;

    @Test
    void findOneByMany() {
        Clazz clazz = clazzMapper.findOneByMany(1);
        log.info(clazz.getClazzId() + "," + clazz.getClazzName());
        clazz.getStudents().forEach(student -> log.info(String.valueOf(student)));
    }

    @Test
    void getClazz() {
        Clazz clazz = clazzMapper.getClazz(1);
        log.info(clazz.getClazzId() + "," + clazz.getTeacher().getTeacherName());
        log.info(clazz.getTeacher().getTeacherId() + "," + clazz.getTeacher().getTeacherName());
        clazz.getStudents().forEach(student -> log.info(String.valueOf(student)));
    }

}