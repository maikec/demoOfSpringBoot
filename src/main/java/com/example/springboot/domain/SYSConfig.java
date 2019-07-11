package com.example.springboot.domain;
/**
 * 公司名称
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * 说明
 *  @author maikec
 *  @date 2019/7/11
 */
@Alias("SYSConfig")
@Data
public class SYSConfig implements Serializable {
    private String variable;
    private String value;
    private Date setTime;
    private String setBy;

}
