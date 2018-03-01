package com.subway.message;

import lombok.Data;

import javax.persistence.*;

/**
 * 留言管理实体类
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Entity
@Table(name = "t_message")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//序号 主键
    private String sortNo;
    private String content;
    private String status;

}
