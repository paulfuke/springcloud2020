package com.dongpo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @className CloudPayment8001
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/4
 * @Version V1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudPayment8001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudPayment8001.class,args);
    }
}
