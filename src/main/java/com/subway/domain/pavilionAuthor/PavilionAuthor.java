package com.subway.domain.pavilionAuthor;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 展馆作者信息
 */
@Entity
@Table(name = "T_PAVILION_AUTHOR")
@Data
public class PavilionAuthor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//序号 主键

    @Column(length = 20, nullable = false)
    private String name;//作者姓名

    @Column(length = 1)
    private String hasPhoto;//是否有会员照片

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createTime;//创建时间

    private Long sortNo;

    @Column(length = 1, nullable = false)
    private String status;//状态
}
