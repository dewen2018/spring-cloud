// package com.dewen.order.service.impl;
//
// import com.dewen.order.entity.Order;
// import com.dewen.order.service.IOrderTcc;
// import io.seata.rm.tcc.api.BusinessActionContext;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
//
// @Slf4j
// @Service
// public class OrderTccService implements IOrderTcc {
//     @Override
//     @Transactional
//     public void tryCreateOrder(String orderId, String orderName, Long productId, Integer count) {
//
//     }
//
//     @Override
//     @Transactional
//     public boolean commit(BusinessActionContext context) {
//         //
//         // 订单状态修改
//         Order order = new Order();
//
//         return true;
//     }
//
//     @Override
//     @Transactional
//     public boolean cancel(BusinessActionContext context) {
//         return false;
//     }
// }
