package com.neo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @ClassName ConsumerApplication
 * @Description: TODO
 * @Author aaa
 * @Date 2019/10/17
 * @Version V1.0
 **/
@EnableDubbo
@EnableHystrix
@SpringBootApplication
public class DubboConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApp.class, args);
    }

}

