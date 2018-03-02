package com.subway.domain.dev;

import lombok.Data;

import javax.persistence.*;

/**
 * 栏目信息
 */
@Entity
@Table(name = "T_APP")
@Data
public class App {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name; //栏目名称

    @Column(length = 50, nullable = false)
    private String packageName; //包名

    @Column(length = 50, nullable = false)
    private String className; //栏目类别

    @Column(length = 20, nullable = false)
    private String tableName;//生效时间

    @Column(length = 50, nullable = false)
    private String appDesc;//生效时间

    @Column(length = 20, nullable = false)
    private String sortNo;//排序

    @Column(length = 1, nullable = false)
    private String status;//状态
}
