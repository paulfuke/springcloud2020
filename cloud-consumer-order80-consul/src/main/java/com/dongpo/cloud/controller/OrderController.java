package com.dongpo.cloud.controller;

import com.dongpo.cloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @className OrderController
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/21
 * @Version V1.0
 **/
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String url_prefix = "http://consul-provider-payment";

    @RequestMapping("/consumer/order")
    public String order() {
        return restTemplate.getForObject(url_prefix + "/payment/consul", String.class);
    }

    @RequestMapping("/consumer/order1")
    public CommonResult<String> order1(){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(url_prefix + "/payment/consul", CommonResult.class);
        System.out.println("code "+forEntity.getStatusCode());
        System.out.println("body "+forEntity.getBody());
        if(forEntity.getStatusCode().is2xxSuccessful())
            return forEntity.getBody();
        else
            return new CommonResult<>(444,"错误");
    }

}
