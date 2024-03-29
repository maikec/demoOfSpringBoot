package com.example.springboot.service;/**
 * 公司名称
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import com.example.springboot.domain.Actor;
import com.example.springboot.vo.UserVO;

/**
 * hello
 *  @author maikec
 *  @date 2019/7/9
 */
public interface HelloService {
    /**
     * demo
     * @return
     */
    String index();

    /**
     * 写入
     * @param actor
     * @return
     */
    Integer save(Actor actor);

    int saveUser(UserVO userVO);
}
