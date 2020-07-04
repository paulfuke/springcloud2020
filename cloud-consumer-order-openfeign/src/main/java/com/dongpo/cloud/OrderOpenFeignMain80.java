package com.dongpo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @className OrderOpenFeignMain80
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/7/2
 * @Version V1.0
 **/
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class OrderOpenFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMain80.class,args);
    }
}
