package com.subway.${className};

import lombok.Data;

import javax.persistence.*;

/**
* ${comment}信息
*/
@Entity
@Table(name = "${tableName}")
@Data
public class ${className?cap_first} {

<#list columnMap?keys as key>
private String ${key};
</#list>

}
