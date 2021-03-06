package com.dongpo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @className OrderZKMain
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/20
 * @Version V1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain.class,args);
    }
}
