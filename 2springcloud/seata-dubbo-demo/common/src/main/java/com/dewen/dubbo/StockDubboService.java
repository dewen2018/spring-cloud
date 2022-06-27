package com.dewen.dubbo;


import com.dewen.dto.CommodityDTO;
import com.dewen.response.ObjectResponse;

/**
 * 库存服务
 */
public interface StockDubboService {

    /**
     * 扣减库存
     */
    ObjectResponse decreaseStock(CommodityDTO commodityDTO);
}
