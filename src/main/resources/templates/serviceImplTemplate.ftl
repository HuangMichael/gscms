package com.subway.${className};

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
public class ${className?cap_first}ServiceImpl implements ${className?cap_first}Service{
	
	@Autowired
	${className?cap_first}Dao ${className}Dao;
    //分页查询
	public List<Map<String,Object>> queryPageList(${className?cap_first}  ${className} ){
		  List<Map<String,Object>> list = ${className}Dao.queryPageList(${className} );
		  return list;	  
	}

	//新增
	public int ${className}Save(${className?cap_first}  ${className} ){
		  int result = ${className}Dao.${className}Save(${className} );
		  return result;
	}
	
	//修改
	public int ${className}Modify(${className?cap_first}  ${className} ){
		  int result = ${className}Dao.${className}Modify(${className} );
		  return result;
	}
	
	//删除
	public int ${className}Dele(${className?cap_first}  ${className} ){
		  int result = ${className}Dao.${className}Dele(${className} );
		  return result;
	}

}
