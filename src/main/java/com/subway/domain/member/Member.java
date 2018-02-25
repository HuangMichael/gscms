package com.subway.domain.member;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 会员信息
 */
@Entity
@Table(name = "T_MEMBER")
@Data
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//序号 主键

    @Column(length = 20, nullable = false)
    private String name;//会员姓名

    @Column(length = 20, nullable = false)
    private String cardNo; //会员证号

    @Column(length = 1)
    private String memberType;//会员类型


    @Column(length = 1)
    private String hasPhoto;//是否有会员照片


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date enterDate;//加入会员日期

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createTime;//创建时间


    private Long sortNo;
    @Column(length = 1, nullable = false, columnDefinition = "default 1")
    private String status;
}
