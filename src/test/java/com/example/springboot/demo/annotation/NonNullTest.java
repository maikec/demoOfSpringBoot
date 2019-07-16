package com.example.springboot.demo.annotation;/**
 * 广州奥凯信息咨询有限公司
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2022. （广州奥凯信息咨询有限公司）all rights reserved.
 */

import com.sun.istack.internal.NotNull;
import lombok.NonNull;

/**
 * 说明
 *  @author maikec
 *  @date 2019/7/10
 */
public class NonNullTest {
    public static void main(String[] args) {
        @NotNull String name  = null ;
        System.out.println(name);
    }
}
