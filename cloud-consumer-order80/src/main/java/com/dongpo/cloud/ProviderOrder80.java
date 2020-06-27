package com.dongpo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @className ProviderOrder80
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/5
 * @Version V1.0
 **/
@SpringBootApplication
@EnableEurekaClient
public class ProviderOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderOrder80.class,args);
    }
}
