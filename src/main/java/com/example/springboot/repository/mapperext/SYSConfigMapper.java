package com.example.springboot.repository.mapperext;
/**
 * 公司名称
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import com.example.springboot.domain.SYSConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

/**
 * 说明
 *  @author maikec
 *  @date 2019/7/11
 */
@Mapper
public interface SYSConfigMapper {
    /**
     * get
     * @param value
     * @return
     * @throws DataAccessException
     */
    @Select("SELECT variable, value, set_time as setTime, set_by as setBy FROM sys_config where value= #{value}")
    SYSConfig getActorByValue(@Param("value") String value) throws DataAccessException;

}
