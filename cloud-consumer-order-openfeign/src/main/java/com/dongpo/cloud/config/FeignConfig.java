package com.dongpo.cloud.config;

import com.sun.javafx.binding.Logging;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className FeignConfig
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/7/2
 * @Version V1.0
 **/
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
