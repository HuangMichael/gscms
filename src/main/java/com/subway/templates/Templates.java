package com.subway.templates;

import lombok.Data;

import javax.persistence.*;

/**
 * ģ�������Ϣ
 */
@Entity
@Table(name = "t_templates")
@Data
public class Templates {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 11, nullable = false)
    private String id;
    private String sortNo;
    private String fileName;
    private String name;
    private String fileUrl;
    private String status;

}
