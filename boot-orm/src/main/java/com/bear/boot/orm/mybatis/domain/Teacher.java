package com.bear.boot.orm.mybatis.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 
 * @TableName t_teacher
 */
@Data
@Alias("Teacher")
public class Teacher implements Serializable {
    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 教师管理的班级id
     */
    private Integer clazzId;

    private static final long serialVersionUID = 1L;
}