package com.example.springboot.demo.reference;/**
 * 广州奥凯信息咨询有限公司
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2022. （广州奥凯信息咨询有限公司）all rights reserved.
 */

/**
 * 说明
 *  @author maikec
 *  @date 2019/7/10
 */
public class Demo {

    public static void main(String[] args) {
        User user = User.builder().build();
        user.id(1).name("5");

        User user2 = new User();
        user2 = user;

        System.out.println(user.toString());
        System.out.println(user2.toString());

        Demo demo = new Demo();
        //值（拷贝）引用传递
        demo.swap(user,user2);

        System.out.println(user.toString());
        System.out.println(user2.toString());
    }

    private void swap(User user, User user2) {
        User tmp = user;
        user = user2;
        user2 = tmp;
    }
}
