package com.dongpo.cloud;

import com.dongpo.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @className ProviderOrder80
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/5
 * @Version V1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class ProviderOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderOrder80.class,args);
    }
}
