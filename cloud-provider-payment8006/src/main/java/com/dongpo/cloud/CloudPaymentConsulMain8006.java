package com.dongpo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @className CloudPaymentConsulMain8006
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/21
 * @Version V1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class CloudPaymentConsulMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(CloudPaymentConsulMain8006.class,args);
    }
}
