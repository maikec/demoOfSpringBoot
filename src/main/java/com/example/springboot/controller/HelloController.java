package com.example.springboot.controller;/**
 * 公司名称
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import com.example.springboot.service.HelloService;
import com.example.springboot.vo.HelloVO;
import com.example.springboot.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 *  demo
 *  @author maikec
 *  @date 2019/7/8
 */
@RestController
@Slf4j
@RequestMapping("helloCtrl")
public class HelloController {

    private final HelloService service;
    public HelloController(HelloService helloService){
        this.service = helloService;
    }
    @RequestMapping("/")
    public String index(){
        log.debug("debug--");
        log.info("info--");
        log.error("error--");
        return service.index();
    }
    @PostMapping("post")
    public String post(@RequestParam(name = "id") String id){
        return id+"Post";
    }

    @PostMapping("postObj")
    public String postObj(@RequestBody HelloVO vo){
        return vo.toString();
    }

    @GetMapping("getObj")
    public String getObj(@Valid HelloVO vo){
        return vo.toString();
    }
    @PostMapping("postObj2")
    public String postObj2( HelloVO vo) throws Exception {
        throw new Exception();
//        return vo.toString();
    }

    @PostMapping("register")
    public String register(@Valid UserVO userVO){
        int insert = service.saveUser(userVO);
        return String.valueOf(insert);
    }
    @PostMapping("login")
    public String login(@Valid UserVO userVO){
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(userVO.getAccount(),new Md5Hash(ByteSource.Util.bytes(
                    userVO.getPassword())).toHex()));
        }catch (AuthenticationException exception){
            log.info("用户校验失败",exception);
        }
        return "1";
    }

}
