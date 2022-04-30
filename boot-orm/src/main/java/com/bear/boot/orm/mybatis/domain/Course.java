package com.bear.boot.orm.mybatis.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 
 * @TableName t_course
 */
@Data
@Alias("Course")
public class Course implements Serializable {
    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 课程名称
     */
    private String courseName;

    private static final long serialVersionUID = 1L;
}