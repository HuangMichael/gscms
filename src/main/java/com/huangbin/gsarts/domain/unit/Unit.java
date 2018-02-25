package com.huangbin.gsarts.domain.unit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 单位信息
 */
@Entity
@Table(name = "T_UNIT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Unit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 20, nullable = false)
    private String code;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String parent;
    @Column(length = 20, nullable = false)
    private String sortNo;
    @Column(length = 1, nullable = false)
    private String status;
}
