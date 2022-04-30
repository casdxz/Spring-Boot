package com.bear.boot.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-14 11:08
 **/
@Data
@Component
/**配置整体前缀*/
@ConfigurationProperties(prefix = "family")
@PropertySource(value = {"classpath:family.yml"})
@Validated
public class Family {

    //@Value("${family.family-name}")
    @Length(min = 5, max = 20, message = "家长名称长度必须在5-20之间。")
    private String familyName;

    private Father father;

    private Mother mother;

    private Child child;

}
