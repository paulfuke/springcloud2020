package com.dongpo.cloud.service;

public interface PaymentService {

    String current_info(Integer id);

    String current_timeout(Integer id);

    String paymentCircuitBreaker(Integer id);
}
