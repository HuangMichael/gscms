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
    @Column(name = "id", length = 11, nullable = false)

    private String id;
    private String content;

}
