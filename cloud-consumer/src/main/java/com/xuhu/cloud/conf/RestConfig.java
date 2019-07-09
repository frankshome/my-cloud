package com.xuhu.cloud.conf;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootConfiguration
public class RestConfig {

    @LoadBalanced
    @Bean("myRestTemplate")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
