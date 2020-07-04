package com.dongpo.cloud.service;

import com.dongpo.cloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult findPaymentById(@PathVariable(value = "id") Integer id);

    @GetMapping("/timeout")
    String timeOut();
}
