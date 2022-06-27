package com.dewen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dewen.entity.TOrder;
import org.apache.ibatis.annotations.Param;

public interface TOrderMapper extends BaseMapper<TOrder> {

    /**
     * 创建订单
     *
     * @Param: order 订单信息
     * @Return:
     */
    void createOrder(@Param("order") TOrder order);
}
