package com.subway.columns;

import com.subway.site.Site;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ��Ŀ��Ϣ
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
    private Site site;  //վ������

    @Column(length = 20, nullable = false)
    private String name; //��Ŀ����

    @Column(length = 20, nullable = false)
    private String type; //��Ŀ���

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date beginTime;//��Чʱ��

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date endTime;//ʧЧʱ��

    @Column(length = 20, nullable = false)
    private String sortNo;//����

    @Column(length = 1, nullable = false)
    private String status;//״̬
}
