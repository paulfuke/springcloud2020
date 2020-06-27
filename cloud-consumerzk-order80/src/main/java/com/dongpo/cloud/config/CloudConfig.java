package com.dongpo.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @className CloudConfig
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/20
 * @Version V1.0
 **/
@Configuration
public class CloudConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getInstance(){
        return new RestTemplate();
    }
}
