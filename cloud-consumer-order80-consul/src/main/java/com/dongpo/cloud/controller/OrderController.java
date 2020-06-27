package com.dongpo.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @className OrderController
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/21
 * @Version V1.0
 **/
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String url_prefix = "http://consul-provider-payment";

    @RequestMapping("/consumer/order")
    public String order() {
        return restTemplate.getForObject(url_prefix + "/payment/consul", String.class);
    }
}
