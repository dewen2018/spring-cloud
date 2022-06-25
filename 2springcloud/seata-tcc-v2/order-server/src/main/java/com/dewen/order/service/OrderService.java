package com.dewen.order.service;

import com.dewen.order.client.AccountClient;
import com.dewen.order.client.ProductClient;
import com.dewen.order.entity.Order;
import com.dewen.order.mapper.OrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private ProductClient productClient;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private AccountClient accountClient;

    @GlobalTransactional(timeoutMills = 60000, name = "demo-all", rollbackFor = Exception.class)
    public void seataDemo(Boolean hasError) {
        //下单操作
        Order order = new Order();
        order.setOrderName("测试数据");
        order.setBuyNum(2);
        orderMapper.insert(order);

        // 减库存
        productClient.minusStock(1L, 2);

        // 减账户余额
        // accountClient.decrease(1L, 200);

        //异常模拟
        if (hasError) {
            int i = 1 / 0;
        }
    }
}
