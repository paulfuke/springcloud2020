package com.dongpo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @className HystrixDashboard9001
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/7/4
 * @Version V1.0
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9001.class,args);
    }


}
