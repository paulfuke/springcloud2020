package com.dongpo.cloud.service.impl;

import com.dongpo.cloud.dao.PaymentDao;
import com.dongpo.cloud.entities.Payment;
import com.dongpo.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @className PaymentServiceImpl
 * @Description: 微信支付服务实现
 * @Author dongpo
 * @Date 2020/6/5
 * @Version V1.0
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment findPaymentById(Integer id) {
        return paymentDao.findPaymentById(id);
    }
}
