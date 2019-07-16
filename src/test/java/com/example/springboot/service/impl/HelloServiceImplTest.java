package com.example.springboot.service.impl;

import com.example.springboot.domain.Actor;
import com.example.springboot.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceImplTest {

    @Resource
    HelloService service;
    @Test
    public void save() {
        AtomicInteger count = new AtomicInteger(65536);
        do {
            Actor actor = new Actor();
            actor.setFirstName("maikec" + count.get());
            actor.setLastName("Chen"+count.get());
            actor.setLastUpdate(new Date());
            Integer save = service.save(actor);
            System.out.println(save.toString());

            count.getAndAdd(1);
        }while (count.get()<500000);
    }
}