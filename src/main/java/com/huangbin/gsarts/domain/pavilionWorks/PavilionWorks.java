package com.huangbin.gsarts.domain.pavilionWorks;

import com.huangbin.gsarts.domain.pavilionAuthor.PavilionAuthor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 展馆作品信息
 */
@Entity
@Table(name = "T_PAVILION_WORKS")
@Data
public class PavilionWorks implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//序号 主键


    @Column(length = 20, nullable = false)
    private String colName;//所属栏目名称


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private PavilionAuthor author;  //作者


    @Column(length = 20, nullable = false)
    private String name;//作品名称


    @Column(length = 1)
    private String isFocus;//是否焦点图片


    @Column(length = 1)
    private String hasPhoto;//是否有会员照片


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date uploadTime;//上传时间

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date releaseTime;//发布时间

    private Long sortNo;//排序

    @Column(length = 1, nullable = false)
    private String status;//状态
}
