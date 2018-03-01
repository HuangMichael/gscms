package com.subway.media;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * 多媒体信息表
 *
 * @author huangbin
 */
@Entity
@Table(name = "T_MEDIA")
@Data
public class Media implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //序号

    @Column(length = 50, nullable = false)
    private String fileName; //多媒体文件名称

    @Column(nullable = false)
    private Long fileSize; //多媒体文件大小，单位为B

    @Column(length = 200, nullable = false)
    private String fileRelativeUrl; //多媒体文件相对路径

    @Column(length = 200)
    private String fileAbsoluteUrl; //多媒体文件绝对路径，精确到盘符

    @Column(length = 200)
    private String thumbNailUrl; //缩略图地址

    @Column(length = 100)
    private String memo; //备注信息

    @Column(length = 1, nullable = false)
    private String status; //状态

    @Column(length = 10, nullable = false, updatable = false)
    private String authKey; //数据权限过滤字段

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.DATE)
    private Date uploadDate; //上传时间精确到时分秒，查询时按照某一天查询

}
