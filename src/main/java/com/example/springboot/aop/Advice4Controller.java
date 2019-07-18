package com.example.springboot.aop;/**
 * 广州奥凯信息咨询有限公司
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2022. （广州奥凯信息咨询有限公司）all rights reserved.
 */

import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.Map;

/**
 * controller增强
 *  @author maikec
 *  @date 2019/7/10
 */
@ControllerAdvice
public class Advice4Controller {
    @ExceptionHandler(ConstraintViolationException.class)
    public String valid(ConstraintViolationException con){
        con.getConstraintViolations().forEach(constraintViolation -> {
            System.out.println(constraintViolation.getMessage());
        });
        Map<String, String> objectObjectMap = Collections.emptyMap();
        objectObjectMap.putIfAbsent("data","2");
        return JSONUtil.toJsonPrettyStr(objectObjectMap);
    }
}
