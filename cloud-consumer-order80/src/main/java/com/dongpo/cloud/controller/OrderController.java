package com.dongpo.cloud.controller;

import com.dongpo.cloud.entities.CommonResult;
import com.dongpo.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @className OrderController
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/5
 * @Version V1.0
 **/
@RestController
@Slf4j
public class OrderController {
    private final String PAYMENT_UTL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> createPayment(Payment payment){
        log.info("测试"+payment);
        return restTemplate.postForObject(PAYMENT_UTL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable(value = "id") Integer id){
        log.info("测试"+id);
        return restTemplate.getForObject(PAYMENT_UTL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/discovery")
    public Object discovery(){
        return restTemplate.getForObject(PAYMENT_UTL + "/payment/discovery", Object.class);
    }
}
