package com.neo.bootstrap;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @ClassName run
 * @Description: TODO
 * @Author aaa
 * @Date 2019/10/18
 * @Version V1.0
 **/
@EnableAutoConfiguration
public class DubboRegistryNacosProviderBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboRegistryNacosProviderBootstrap.class)
                .run(args);
    }
}
