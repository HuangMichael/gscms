package com.subway.memberWorks;


import com.subway.domain.units.Unit;
import com.subway.member.Member;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ��Ա��Ʒ��Ϣ
 */
@Entity
@Table(name = "T_MEMBER_WORKS")
@Data
public class MemberWorks implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//��� ����

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private Unit unit;//����Э��

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member;  //������Ա

    @Column(length = 50, nullable = false)
    private String name;//��Ʒ����

    @Column(length = 1, nullable = false)
    private String isFocus;//�Ƿ񽹵���Ʒ

    @Column(length = 1)
    private String memberType;//��Ա����

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date uploadTime;//�ϴ�ʱ��

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date releaseTime;//����ʱ��

    private Long sortNo;

    @Column(length = 1, nullable = false)
    private String status;
}
