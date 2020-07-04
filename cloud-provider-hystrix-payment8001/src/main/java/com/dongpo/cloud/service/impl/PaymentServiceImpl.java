package com.dongpo.cloud.service.impl;

import com.dongpo.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;


/**
 * @className PaymentServiceImpl
 * @Description: 微信支付服务实现
 * @Author dongpo
 * @Date 2020/6/5
 * @Version V1.0
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Value("${server.port}")
    private String serverPort;

    private final static long TIME_BLOCK = 2;
    @Override
    public String current_info(Integer id) {
        return "current Thread is "+Thread.currentThread().getName()+" port "+serverPort;
    }

    @Override
    public String current_timeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(TIME_BLOCK);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Time out and block time is "+TIME_BLOCK +"s";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸--当前请求10个当6个失败就跳闸
    })
    public String paymentCircuitBreaker(@PathVariable(value = "id") Integer id){
        if(id < 0)
            throw new RuntimeException("id 不能为负数");
        else
            return "id 的置为 "+ id;
    }

    private String paymentCircuitBreaker_fallback(Integer id){
        return "程序 出现异常了o(╥﹏╥)o";
    }
}
