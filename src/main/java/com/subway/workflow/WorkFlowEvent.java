package com.subway.workflow;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by huangbin on 2018-3-3
 * 工作流节点事件定义
 */
@Entity
@Table(name = "T_WORK_FLOW_EVENT")
@Data
public class WorkFlowEvent implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 11, nullable = false)
    private Long id; //序号

    @Column(name = "name", length = 20, nullable = false)
    private String name; //工作流程名称

    @Column(length = 50)
    private String description; //工作流程名称


    @Column(length = 1, nullable = false)
    private boolean isAuto; //状态

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date triggerTime; //触发时间


    @Column(length = 1, nullable = false)
    private Long sortNo; //状态

    @Column(length = 1, nullable = false)
    private String status; //状态


}
