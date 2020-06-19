package com.neo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @ClassName run
 * @Description: TODO
 * @Author aaa
 * @Date 2019/10/18
 * @Version V1.0
 **/
@EnableDubbo
@EnableHystrix
@SpringBootApplication
public class DubboProviderApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboProviderApp.class).run(args);
    }
}
