package com.subway.columnsContent;


import com.subway.columns.Columns;
import com.subway.site.Site;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 栏目内容
 */
@Entity
@Table(name = "T_COLUMNS_CONTENT")
@Data
public class ColumnsContent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(length = 20, nullable = false)
    private String title;


    @Column(length = 5000, nullable = false)
    private String content;


    @Column(length = 100, nullable = false)
    private String focusPicUrl;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date releaseTime;

    @Column(length = 20, nullable = false)
    private String creator;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_id", referencedColumnName = "id")
    private Site site;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "columns_id", referencedColumnName = "id")
    private Columns columns;


    @Column(length = 20, nullable = false)
    private String sortNo;


    @Column(length = 10, nullable = false)
    private String auditStatus;


    @Column(length = 1, nullable = false)
    private String status;
}

