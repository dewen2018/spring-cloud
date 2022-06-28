package com.dewen.dubbo;


import com.dewen.dto.OrderDTO;
import com.dewen.response.ObjectResponse;

/**
 * 订单服务接口
 */
public interface OrderDubboService {

    /**
     * 创建订单
     */
    ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO);
}
