package com.example.springboot.demo.annotation;/**
 * 广州奥凯信息咨询有限公司
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2022. （广州奥凯信息咨询有限公司）all rights reserved.
 */

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * 注解的继承demo
 *  @author maikec
 *  @date 2019/7/10
 */
@Deprecated
@InheritedAnnotation
public class InheritedChildTest extends InheritedTest {
    public static void main(String[] args) throws ClassNotFoundException {
        annotations();


//        Class<?> clazz = Class.forName(InheritedChildTest.class.getName());
//        Arrays.asList(clazz.getAnnotations()).forEach(annotation -> {
//            System.out.println(annotation.toString());
//        });
//
//        System.out.println("----");
//        Class<?> aClass = Class.forName(InheritedChildTest.class.getName());
//        Arrays.asList(aClass.getDeclaredAnnotations()).forEach(annotation -> {
//            System.out.println(annotation.toString());
//        });
    }

    private static void annotations() {
        for (Annotation annotation : InheritedChildTest.class.getAnnotations()) {
            System.out.println(annotation.toString());
        }
        System.out.println("----");
        for (Annotation annotation : InheritedChildTest.class.getDeclaredAnnotations()) {
            System.out.println(annotation.toString());
        }

        System.out.println(InheritedChildTest.class.getAnnotations()
                == InheritedChildTest.class.getDeclaredAnnotations());

        System.out.println(Arrays.equals(InheritedChildTest.class.getDeclaredAnnotations(),
                InheritedChildTest.class.getAnnotations()));
    }
}
