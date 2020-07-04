package com.dongpo.cloud.controller;

import com.dongpo.cloud.entities.CommonResult;
import com.dongpo.cloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @className OrderFeignController
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/7/2
 * @Version V1.0
 **/
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult findPaymentById(@PathVariable(value = "id") Integer id) {
        return paymentFeignService.findPaymentById(id);
    }

    @GetMapping("/consumer/timeout")
    public String timeout(){
        return paymentFeignService.timeOut();
    }
}
