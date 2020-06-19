package com.neo.service;

import com.neo.DemoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName DefaultEchoService
 * @Description: TODO
 * @Author aaa
 * @Date 2019/10/17
 * @Version V1.0
 **/
@Service(group = "provider", version = "${demo.service.version}")
public class DefaultDemoService implements DemoService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("[%s] : Hello, %s", serviceName, name);
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
    @Override
    public String service1() {
        return "调用了provider的service1";
    }


}
