package com.subway.domain.memberWorks;


import com.subway.domain.member.Member;
import com.subway.domain.units.Unit;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 会员作品信息
 */
@Entity
@Table(name = "T_MEMBER_WORKS")
@Data
public class MemberWorks implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//序号 主键

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private Unit unit;//所属协会

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member;  //所属会员

    @Column(length = 50, nullable = false)
    private String name;//作品名称

    @Column(length = 1, nullable = false)
    private String isFocus;//是否焦点作品

    @Column(length = 1)
    private String memberType;//会员类型

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date uploadTime;//上传时间

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date releaseTime;//发布时间

    private Long sortNo;

    @Column(length = 1, nullable = false)
    private String status;
}
