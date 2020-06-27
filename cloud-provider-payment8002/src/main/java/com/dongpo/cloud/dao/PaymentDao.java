package com.dongpo.cloud.dao;

import com.dongpo.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment findPaymentById(Integer id);
}
