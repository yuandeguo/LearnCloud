package com.yuan.springcloud.sc3;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Consumer;
import java.util.function.Supplier;


/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/1/25 18:17
 * @Description null
 */
@Configuration
@Slf4j
public class PubSubDemo {

    @Bean
    public Consumer<String> inputRabbit1() {
        return str -> {
            log.info("inputRabbit1 message: {}", str);
        };
    }

    @Bean
    public Consumer<String> inputRabbit2() {
        return str -> {
            log.info("inputRabbit2 message: {}", str);
        };
    }

    //@Bean
    public Supplier<String> outputRabbit() {
        return ()->{
            String outputRabbit_message="outputRabbit_message";
            log.info(outputRabbit_message);
            return outputRabbit_message;
        };
    }

}
