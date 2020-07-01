package com.dongpo.cloud.controller;

import com.dongpo.cloud.entities.CommonResult;
import com.dongpo.cloud.entities.Payment;
import com.dongpo.cloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className OrderController
 * @Description: TODO
 * @Author dongpo
 * @Date 2020-6-5
 * @Version V1.0
 **/
@RestController
@Slf4j
public class OrderController {
    private final String PAYMENT_UTL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalance loadBalance;
    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/consumer/payment/lb")
    public String loadBalance(){
        //获取服务器实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() <= 0)
            return null;
        ServiceInstance serviceInstance = loadBalance.getServiceInstance(instances);
        return restTemplate.getForObject(serviceInstance.getUri()+"/payment/lb",String.class);
    }
}
