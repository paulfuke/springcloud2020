package com.dongpo.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className TestController
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/7/1
 * @Version V1.0
 **/
@RestController
@Slf4j
public class TestController {

    @RequestMapping("/test/consumer")
    public void testConsumer(){


    }
}
