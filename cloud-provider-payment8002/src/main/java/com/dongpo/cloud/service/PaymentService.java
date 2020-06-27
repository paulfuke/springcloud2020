package com.dongpo.cloud.service;

import com.dongpo.cloud.entities.Payment;

public interface PaymentService {

    public int create(Payment payment);

    public Payment findPaymentById(Integer id);

}
