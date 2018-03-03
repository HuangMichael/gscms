package com.subway.${subDirName};

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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
public class ${className}  implements Serializable {

<#list columns as c>
private ${c.dataType} ${c.colName};
</#list>

}
