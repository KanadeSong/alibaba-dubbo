package com.neo.controller;

import com.neo.DemoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author 李佳杰
 * @Date 2019/12/12
 * @Version V1.0
 **/
@RestController
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(check = false, group = "provider", version = "${demo.service.version}")
    private DemoService demoService;

    @GetMapping(value = "/test")
    public Object test() {
        String st = "这是一个字符串";
        return st;
    }

    @HystrixCommand(fallbackMethod = "reliable")
    @GetMapping(value = "/service1")
    private String service1() {
        return demoService.service1();
    }

    public String reliable() {
        return "this is a reliable";
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> logger.info(demoService.sayHello("mercyblitz"));
    }

}
