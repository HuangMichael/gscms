package com.subway.domain.dev;

import lombok.Data;

import javax.persistence.*;

/**
 * 模板信息
 */
@Entity
@Table(name = "T_TEMPLATE")
@Data
public class Template {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20, nullable = false)
    private String templateName; //模板名称

    @Column(length = 50, nullable = false)
    private String templateUrl;//模板路径

    @Column(length = 50, nullable = false)
    private String templateDesc;//模板描述

    @Column(length = 20, nullable = false)
    private String sortNo;//排序

    @Column(length = 1, nullable = false)
    private String status;//状态
}
