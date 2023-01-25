package com.yuan.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/1/24 17:06
 * @Description RefreshScope是Config动态刷新
 * 需要运维人员发送Post请求刷新3355
 * POST "http://localhost:3355/actuator/refresh"
 */
@RefreshScope
@RestController
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return configInfo;
    }
}
