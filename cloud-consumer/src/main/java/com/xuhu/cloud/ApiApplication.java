package com.xuhu.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EnableDiscoveryClient相比较EnableEurekaClient
 * 前者适用范围更广, 可在zookeeper consul等中使用
 */
@RestController
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Value("${server.port}")
    String port;
    @GetMapping("/")
    public String home() {
        return "api running, port=" + port;
    }
}
