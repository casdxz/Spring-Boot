package com.bear.boot.orm.entity;

import com.bear.boot.orm.listener.DataBaseAuditListener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-18 09:03
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(DataBaseAuditListener.class)
public class Article implements Serializable {

    @Serial
    private static final long serialVersionUID = -2631847427215494114L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String author;

    private String title;

    private String thumbnail;

    private String content;

    @Column(name = "create_time",updatable = false)
    private Date createTime;

    private Date updateTime;

}
