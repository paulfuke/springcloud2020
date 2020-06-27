package com.dongpo.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @className RestConfig
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/21
 * @Version V1.0
 **/
@Configuration
public class RestConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getInstance(){
        return new RestTemplate();
    }
}
