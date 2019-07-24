package com.example.springboot.service.impl;/**
 * 公司名称
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import com.example.springboot.domain.Actor;
import com.example.springboot.domain.SYSConfig;
import com.example.springboot.domain.User;
import com.example.springboot.repository.mapper.ActorMapper;
import com.example.springboot.repository.mapperext.SYSConfigMapper;
import com.example.springboot.service.HelloService;
import com.example.springboot.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.util.ByteSource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 说明
 *  @author maikec
 *  @date 2019/7/9
 */
@Service
@Slf4j
public class HelloServiceImpl implements HelloService {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    @Resource
    @Qualifier("defaultSqlSession")
    private SqlSessionTemplate sqlSessionTemplateSe;

    @Resource
    private SYSConfigMapper configMapper;
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

        final SYSConfig actorByValue = configMapper.getActorByValue("100");
        System.out.println(actorByValue.toString());

        final Actor o = sqlSessionTemplate.selectOne("getActorById", 3);
        final SYSConfig config = sqlSessionTemplateSe.selectOne("getActorByValue", "64");

        System.out.println(o.toString());

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

    @Override
    public Integer save(Actor actor) {
        return mapper.save(actor);
    }

    @Override
    public int saveUser(UserVO userVO) {
        User user = new User();
        BeanUtil.copyProperties(userVO,user);
        user.setPassword(new Md5Hash(ByteSource.Util.bytes(user.getPassword())).toHex());
        user.setId(RandomUtil.randomInt(1,100000));
        user.setSalt(RandomUtil.randomString(6));
        return mapper.saveUser(user);
    }
}
