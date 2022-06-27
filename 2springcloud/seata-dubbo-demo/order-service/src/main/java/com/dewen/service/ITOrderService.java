package com.dewen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dewen.dto.OrderDTO;
import com.dewen.entity.TOrder;
import com.dewen.response.ObjectResponse;


public interface ITOrderService extends IService<TOrder> {

    /**
     * 创建订单
     */
    ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO);
}
