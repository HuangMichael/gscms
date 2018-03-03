package com.subway.message;

import com.subway.columns.Columns;
import com.subway.domain.person.Person;
import com.subway.site.Site;
import lombok.Data;

import javax.persistence.*;

/**
 * 留言管理实体类
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
    private Long id;//序号 主键

    @OneToOne
    @JoinColumn(name = "site_id")
    private Site site; //所属站点

    @OneToOne
    @JoinColumn(name = "columns_id")
    private Columns columns; //所属栏目

    private String content;

    private String sortNo;

    private String status;

}
