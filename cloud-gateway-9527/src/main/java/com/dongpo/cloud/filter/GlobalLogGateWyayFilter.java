package com.dongpo.cloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @className GlobalLogGateWyayFilter
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/7/9
 * @Version V1.0
 **/
@Component
@Slf4j
public class GlobalLogGateWyayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("come in filter***********");
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if(username == null){
            System.out.println("当前用户名为null--------");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
