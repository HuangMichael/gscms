package com.subway.workflow;


import com.subway.domain.person.Person;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by huangbin on 2018-3-3
 * 工作流节点定义
 */
@Entity
@Table(name = "T_WORK_FLOW_NODE")
@Data
public class WorkFlowNode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 11, nullable = false)
    private Long id; //序号

    @Column(name = "name", length = 20, nullable = false)
    private String name; //工作流程名称

    @Column(length = 50)
    private Long nodeIndex; //节点索引

    @Column(length = 50)
    private String nodeDesc; //节点描述

    @OneToOne
    @JoinColumn(name = "work_flow_id")
    private WorkFlow workFlow;

    @Column(length = 1, nullable = false)
    private Long sortNo; //状态

    @Column(length = 1, nullable = false)
    private String status; //状态
}
