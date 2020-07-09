package com.dongpo.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className ConfigClientController
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/7/9
 * @Version V1.0
 **/
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    public String configInfo;

    @GetMapping("/info")
    public String configInfo(){
        return configInfo;
    }
}
