package com.example.springboot.vo;/**
 * 广州奥凯信息咨询有限公司
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2022. （广州奥凯信息咨询有限公司）all rights reserved.
 */

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 说明
 *  @author maikec
 *  @date 2019/7/10
 */
@Data
public class UserVO implements Serializable {
    @NotNull(message = "名称不能为空")
    private String name;
    @NotNull(message = "密码不能为空")
    private String password;
    @NotNull(message = "账号不能为空")
    private String account;
}
