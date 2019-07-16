package com.example.springboot.demo.annotation;/**
 * 广州奥凯信息咨询有限公司
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2022. （广州奥凯信息咨询有限公司）all rights reserved.
 */

import java.util.Arrays;

/**
 * 说明
 *  @author maikec
 *  @date 2019/7/10
 */
public class RepeatTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName(RepeatTest.class.getName());
        Arrays.asList(aClass.getMethods()).forEach(method -> {
            if (method.getName().startsWith("t")){
                System.out.println(method.getName());
                Arrays.asList(method.getAnnotations()).forEach(annotation -> {
                    if (annotation instanceof RepeatAnnotations){
                        Arrays.asList(((RepeatAnnotations) annotation).value()).forEach(repeatAnnotation -> {
                            System.out.println(repeatAnnotation.value());
                        });
                    }
                });
            }
        });
    }

    @RepeatAnnotation("1")
    @RepeatAnnotation("2")
    public void t(){

    }
    @RepeatAnnotations({
            @RepeatAnnotation("11"),
            @RepeatAnnotation("12")
    })
    public void t2(){

    }

}
