package com.dongpo.cloud.controller;

import com.dongpo.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @className OrderController
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/7/3
 * @Version V1.0
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalHandler")
public class OrderController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand
//    @HystrixCommand(fallbackMethod = "fallBackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        int i = 1 / 0;
        return paymentService.paymentInfo_TimeOut(id);
    }

    private String fallBackMethod(Integer id){
        return "服务器拥挤会出现故障，请稍后重试";
    }

    private String globalHandler(){
        return "globalHandler 服务器故障";
    }
}
