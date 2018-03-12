package com.subway.pavilionAuthor;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 展馆作者信息实体类
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Entity
@Table(name = "t_pavilion_author")
@Data
public class PavilionAuthor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String photoUrl;
    private String hasPhoto;
    private Date createTime;
    private Long sortNo;
    private String status;

}
