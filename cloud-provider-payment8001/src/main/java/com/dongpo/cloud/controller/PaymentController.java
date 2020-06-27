package com.dongpo.cloud.controller;

import com.dongpo.cloud.entities.CommonResult;
import com.dongpo.cloud.entities.Payment;
import com.dongpo.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
    @Autowired
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        log.info("插入数据"+payment);
        int result = paymentService.create(payment);
        log.info("插入结果"+result);
        if(result > 0)
            return new CommonResult(200,"插入成功serverPort: "+serverPort,null);
        return new CommonResult(444,"插入失败",null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult findPaymentById(@PathVariable(value = "id") Integer id){
        Payment payment = paymentService.findPaymentById(id);
        log.info("查询结果"+payment);
        if(payment != null)
            return new CommonResult(200,"查询成功serverPort: "+serverPort,payment);
        return new CommonResult(444,"暂无记录",null);
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        //获取所有服务名称
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("******service: "+service);
        }

        //获取某个服务的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("*******"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }
}
