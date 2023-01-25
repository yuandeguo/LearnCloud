package com.yuan.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/1/25 16:50
 * @Description null
 */
@RestController
@Slf4j
public class SendMessageController {
    @Autowired
    private StreamBridge bridge;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(String message) {
        boolean send=   bridge.send("outputRabbit-out-0",message);
        log.info("outputRabbit-out-0 =====" +send);
return message;
    }
}
