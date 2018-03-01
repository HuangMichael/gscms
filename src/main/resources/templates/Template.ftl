package com.subway.${className};

import lombok.Data;

import javax.persistence.*;

/**
* ${comment}实体类
*
* @author huangbin
* @generate by autoCode
* @Date 2018-3-1
*/
@Entity
@Table(name = "${tableName}")
@Data
public class ${className?cap_first} {

<#list columnMap?keys as key>
private String ${key};
</#list>

}
