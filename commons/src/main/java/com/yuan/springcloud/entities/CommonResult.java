package com.yuan.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/1/11 21:41
 * @Description null
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>{
    //404等编码
    private Integer code;
    //成功等信息
    private String message;
    private T data;

    public CommonResult(Integer code, String message){
        this(code, message, null);
    }
}
