package com.dongpo.cloud.controller;

import com.dongpo.cloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @className PaymentContoller
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/21
 * @Version V1.0
 **/
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public CommonResult payment(){
        return new CommonResult(200, "consul provider and serverPort: " + serverPort + UUID.randomUUID().toString());
    }
}
