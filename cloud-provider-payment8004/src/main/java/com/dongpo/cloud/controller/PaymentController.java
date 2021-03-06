package com.dongpo.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @className PaymentController
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/7
 * @Version V1.0
 **/
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/zk")
    public String payment_zk(){
        return "zookeeper PaymentController serverPort : "+serverPort+ "\t"+UUID.randomUUID().toString();
    }
}
