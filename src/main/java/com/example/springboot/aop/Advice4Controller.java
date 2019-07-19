package com.example.springboot.aop;/**
 * 广州奥凯信息咨询有限公司
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2022. （广州奥凯信息咨询有限公司）all rights reserved.
 */

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * controller增强
 *  @author maikec
 *  @date 2019/7/10
 */
@ControllerAdvice
public class Advice4Controller {
    /**
     * 入参校验
     * @param bindException 绑定的校验信息
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public String valid(BindException bindException){
        JSONObject obj = JSONUtil.createObj();
        bindException.getAllErrors().forEach(objectError -> {
            obj.putIfAbsent(((FieldError)objectError).getField(),objectError.getDefaultMessage());
        });
        return obj.toStringPretty();
    }
}
