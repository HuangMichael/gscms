package com.subway.domain.columns;

import com.subway.site.Site;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 栏目信息
 */
@Entity
@Table(name = "T_COLUMNS")
@Data
public class Columns implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_id", referencedColumnName = "id")
    private Site site;  //站点名称

    @Column(length = 20, nullable = false)
    private String name; //栏目名称

    @Column(length = 20, nullable = false)
    private String type; //栏目类别

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date beginTime;//生效时间

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date endTime;//失效时间

    @Column(length = 20, nullable = false)
    private String sortNo;//排序

    @Column(length = 1, nullable = false)
    private String status;//状态
}
