package com.xuhu.cloud.conf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;



@Configuration
public class RestConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    /**
     * 负载均衡规则
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RoundRobinRule();
//        return new RandomRule();
    }

}
