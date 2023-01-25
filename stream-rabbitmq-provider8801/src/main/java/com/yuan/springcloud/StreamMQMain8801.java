package com.yuan.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Supplier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/1/25 15:00
 * @Description null
 */
@SpringBootApplication
@Slf4j
public class StreamMQMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQMain8801.class,args);
    }


}
