package com.subway.member;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * ��Ա����实体�?
 *
 * @author huangbin
 * @generate by autoCode
 * @Date 2018-3-1
 */
@Entity
@Table(name = "t_member")
@Data
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//��� ����
    private String sortNo;
    private String enterDate;
    private String hasPhoto;
    private String createTime;
    private String name;
    private String memberType;
    private String cardNo;
    private String status;
    private String authKey;

}
