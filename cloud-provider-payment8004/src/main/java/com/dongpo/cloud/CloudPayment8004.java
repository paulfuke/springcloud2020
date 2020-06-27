package com.dongpo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @className CloudPayment8004
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/7
 * @Version V1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class CloudPayment8004 {
    public static void main(String[] args) {
        SpringApplication.run(CloudPayment8004.class,args);
    }
}
