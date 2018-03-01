package com.subway.media;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * ��ý����Ϣ��
 *
 * @author huangbin
 */
@Entity
@Table(name = "T_MEDIA")
@Data
public class Media implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //���

    @Column(length = 50, nullable = false)
    private String fileName; //��ý���ļ�����

    @Column(nullable = false)
    private Long fileSize; //��ý���ļ���С����λΪB

    @Column(length = 200, nullable = false)
    private String fileRelativeUrl; //��ý���ļ����·��

    @Column(length = 200)
    private String fileAbsoluteUrl; //��ý���ļ�����·������ȷ���̷�

    @Column(length = 200)
    private String thumbNailUrl; //����ͼ��ַ

    @Column(length = 100)
    private String memo; //��ע��Ϣ

    @Column(length = 1, nullable = false)
    private String status; //״̬

    @Column(length = 10, nullable = false, updatable = false)
    private String authKey; //����Ȩ�޹����ֶ�

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.DATE)
    private Date uploadDate; //�ϴ�ʱ�侫ȷ��ʱ���룬��ѯʱ����ĳһ���ѯ

}
