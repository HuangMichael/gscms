package com.subway.${className};

import java.util.List;
import java.util.Map;

/**
* ${comment}业务类
*  huangbin
*/


public interface ${className?cap_first}Service {


@Autowired
${className?cap_first}Repository ${className?cap_first}Repository;

/**
* @return 查询所有的${comment}
*/
public List<Member> findAll() {
    return  ${className}Repository.findAll();
    }


    /**
    * @return 查询所有的${comment}
    */
    public Page< ${className?cap_first}> findAll(Pageable pageable) {
        return  ${className}Repository.findAll(pageable);
        }


        /**
        * @return 查询所有的${comment}
        */
        public List< ${className?cap_first}> findByName(String name) {
            return  ${className}Repository.findByNameContaining(name);
            }


            /**
            * @param id
            * @return 根据ID查询${comment}
            */
            public  ${className?cap_first} findById(Long id) {
            return  ${className}Repository.findById(id);
            }

}
