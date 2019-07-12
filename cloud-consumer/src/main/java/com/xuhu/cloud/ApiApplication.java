package com.xuhu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

/**
 * EnableDiscoveryClient相比较EnableEurekaClient
 * 前者适用范围更广, 可在zookeeper consul等中使用
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
