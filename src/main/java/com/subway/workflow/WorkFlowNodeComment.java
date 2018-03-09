package com.subway.workflow;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by huangbin on 2018-3-3
 * 工作流节点定义
 */
@Entity
@Table(name = "T_WORK_FLOW_NODE_COMMENT")
@Data
public class WorkFlowNodeComment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 11, nullable = false)
    private Long id; //序号

    @Column(name = "comment", length = 200, nullable = false)
    private String comment; //工作流程名称

    @OneToOne
    @JoinColumn(name = "work_flow_id")
    private WorkFlow workFlow;

    @Column(length = 1, nullable = false)
    private Long sortNo; //状态

    @Column(length = 1, nullable = false)
    private String status; //状态
}
