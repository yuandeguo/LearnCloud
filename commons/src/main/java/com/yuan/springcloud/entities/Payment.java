package com.yuan.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/1/11 21:39
 * @Description null
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Long id;
    private String serial;
}
