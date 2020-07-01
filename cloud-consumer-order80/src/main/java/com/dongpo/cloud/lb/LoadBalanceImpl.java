package com.dongpo.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @className LoadBalanceImpl
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/7/1
 * @Version V1.0
 **/
@Component
public class LoadBalanceImpl implements LoadBalance{
    private AtomicInteger count = new AtomicInteger(0);
    //计算出当前轮询的list下标
    private int getNext(){
        int current;
        int next;
        do {
            current = count.get();
            next = current >= 2147483647 ? 0 : current+1;
        }while(!count.compareAndSet(current,next));
        System.out.println("当前访问次数 = "+next);
        return next;
    }
    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> instances) {
        int index = getNext() % instances.size();
        System.out.println("下标 = "+index);
        return instances.get(index);
    }
}
