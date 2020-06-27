package com.dongpo.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @className OrderController
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/20
 * @Version V1.0
 **/
@RestController
public class OrderController {

    @Value("${server.url_prefix}")
    private String url_prefix;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/zk")
    public String consumer(){
        return restTemplate.getForObject(url_prefix + "/payment/zk", String.class);
    }

}
