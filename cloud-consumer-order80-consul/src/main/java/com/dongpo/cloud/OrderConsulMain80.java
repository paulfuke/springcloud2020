package com.dongpo.cloud;

import com.dongpo.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @className OrderConsulMain80
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/21
 * @Version V1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "consul-provider-payment",configuration = MySelfRule.class)
public class OrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class,args);
    }
}
