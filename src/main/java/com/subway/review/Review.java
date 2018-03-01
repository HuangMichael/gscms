package com.subway.review;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * �����б�实体�?
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Entity
@Table(name = "t_review")
@Data
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//序号 主键
    private Long sortNo;
    private String columnId;
    private String status;
}
