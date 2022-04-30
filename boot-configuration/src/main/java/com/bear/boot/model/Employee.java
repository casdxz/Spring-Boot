package com.bear.boot.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

/**
 * @program: IntelliJ IDEA
 * @description: @Configuration注解，表示本类为一个配置类
 * @author: bear
 * @create: 2022-03-14 15:40
 **/
@Data
@Configuration
@PropertySource(name = "employeeProperties",value = "classpath:employee.properties")
public class Employee {

    /**
     * 使用SpEL读取 employee.properties 配置文件
     */
    @Value("#{'${employee.names]'.split(',')}")
    private List<String> employeeNames;

    @Value("#{'${employee.names]'.split(',')[0]}")
    private String firstName;
    @Value("#{${employee.age}}")
    private Map<String, Integer> employeeAge;

    @Value("#{${employee.age}['three'] !=null ?  ${employee.age}['three'] : 18}")
    private Integer ageWithDefaultValue;

    @Value("#{systemProperties['java.home']}")
    private String javaHome;

    @Value("#{systemProperties['user.dir']}")
    private String userDir;
}
