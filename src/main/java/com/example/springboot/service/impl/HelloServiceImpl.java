package com.example.springboot.service.impl;/**
 * 公司名称
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import cn.hutool.core.util.IdUtil;
import com.example.springboot.domain.Actor;
import com.example.springboot.repository.mapper.ActorMapper;
import com.example.springboot.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 说明
 *  @author maikec
 *  @date 2019/7/9
 */
@Service
@Slf4j
public class HelloServiceImpl implements HelloService {
    private final ActorMapper mapper;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public HelloServiceImpl(ActorMapper actorMapper){
        this.mapper = actorMapper;
    }
    @Override
    public String index() {
        log.debug("debug in {}",getClass().getName());
        log.error("error in {}",getClass().getName());
        log.info("info in {}",getClass().getSimpleName());


        final Actor actor = mapper.getActorById(1);
//        final Actor selectCityById = mapper.selectCityById(2);
//        System.out.println(selectCityById.toString());

        final List<Actor> actorList = mapper.getActor();
        System.out.println(actorList.size());

        System.out.println(actor.toString());

        final int i = 1 / 0;
        System.out.println(i);
        return IdUtil.randomUUID();
    }
}
