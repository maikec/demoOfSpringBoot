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
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *  demo
 *  @author maikec
 *  @date 2019/7/8
 */
@RestController
@Slf4j
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
    public String postObj2( HelloVO vo){
        return vo.toString();
    }
}
