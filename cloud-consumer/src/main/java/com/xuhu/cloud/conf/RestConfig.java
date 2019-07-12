package com.xuhu.cloud.conf;

<<<<<<< HEAD
=======
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringBootConfiguration;
>>>>>>> a8689a617637afd6aa31d1ee83e100478e262c57
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
