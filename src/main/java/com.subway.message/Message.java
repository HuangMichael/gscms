package com.subway.message;

import lombok.Data;

import javax.persistence.*;

/**
 * 留言管理信息
 */
@Entity
@Table(name = "t_message")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 20, unique = true, nullable = false)
    private String content;

}
