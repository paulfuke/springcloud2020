package com.dongpo.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className MySelfRule
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/7/1
 * @Version V1.0
 **/
@Configuration
public class MySelfRule {
    @Bean
    public IRule getInstance(){
        return new RandomRule();
    }
}
