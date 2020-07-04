package com.dongpo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @className OrderHystrixOpenfeign80
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/7/3
 * @Version V1.0
 **/
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
public class OrderHystrixOpenfeign80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixOpenfeign80.class,args);
    }
}
