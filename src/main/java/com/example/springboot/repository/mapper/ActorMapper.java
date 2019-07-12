package com.example.springboot.repository.mapper;
/**
 * 公司名称
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import com.example.springboot.domain.Actor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * 说明
 *  @author maikec
 *  @date 2019/7/11
 */
@Mapper
public interface ActorMapper {
    /**
     * get
     * @param id
     * @return
     * @throws DataAccessException
     */
    @Select("select actor_id as actorId ,first_name as firstName,last_name as lastName, last_update as lastUpdate from actor where actor_id = #{id}")
    Actor getActorById(@Param("id") Integer id) throws DataAccessException;

    /**
     * 获取列表
     * @return
     * @throws DataAccessException
     */
    @Select("select actor_id as actorId ,first_name as firstName,last_name as lastName, last_update as lastUpdate from actor;")
    List<Actor> getActor() throws DataAccessException;
    /**
     * 获取
     * @param id
     * @return
     * @throws DataAccessException
     */
    Actor selectCityById(@Param("id") Integer id) throws DataAccessException;
}
