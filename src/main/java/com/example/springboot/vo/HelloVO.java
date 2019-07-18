package com.example.springboot.vo;
/**
 * 公司名称
 * <p>
 * 本源代码由《springboot》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 *  demo vo
 *  @author maikec
 *  @date 2019/7/8
 */
@Data
public class HelloVO implements Serializable {
    @Min(value = 1,message = "不能小于1")
    @Max(value = 100,message = "不能大于100")
    private Integer id;
    @NotNull(message = "value不能为空")
    private String value;
}
