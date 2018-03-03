package com.subway.message;

import com.subway.columns.Columns;
import com.subway.domain.person.Person;
import com.subway.site.Site;
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
    private Long id;//��� ����

    @OneToOne
    @JoinColumn(name = "site_id")
    private Site site; //����վ��

    @OneToOne
    @JoinColumn(name = "columns_id")
    private Columns columns; //������Ŀ

    private String content;

    private String sortNo;

    private String status;

}
