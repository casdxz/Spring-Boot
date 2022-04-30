package com.bear.boot.orm.mybatis.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 
 * @TableName t_course_student
 */
@Data
@Alias("CourseStudent")
public class CourseStudent implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 学生id
     */
    private Integer studentId;

    private static final long serialVersionUID = 1L;
}