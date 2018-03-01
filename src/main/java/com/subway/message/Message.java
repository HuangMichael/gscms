package com.subway.message;

import lombok.Data;

import javax.persistence.*;

/**
 * ���Թ���ʵ����
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
    @Column(name = "id", length = 11, nullable = false)
    private Long id; //序号
    private String content;

}
