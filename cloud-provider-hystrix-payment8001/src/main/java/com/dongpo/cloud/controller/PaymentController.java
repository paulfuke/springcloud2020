package com.dongpo.cloud.controller;

import com.dongpo.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;


/**
 * @className PaymentController
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/5
 * @Version V1.0
 **/
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable(value = "id") Integer id){
        String s = paymentService.current_info(id);
        log.info(s);
        return s;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "payment_timeout_handler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String payment_timeout(@PathVariable(value = "id") Integer id){
        String s = paymentService.current_timeout(id);
        log.info(s);
        return s;
    }

    @GetMapping("/payment/circuit/breaker/{id}")
    public String circuitBreaker(@PathVariable(value = "id")Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }

    private String payment_timeout_handler(Integer id){
        return "服务器繁忙，请稍后再试!";
    }

}
