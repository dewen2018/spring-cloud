package com.dewen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dewen.dto.CommodityDTO;
import com.dewen.entity.TStock;
import com.dewen.response.ObjectResponse;

public interface ITStockService extends IService<TStock> {

    /**
     * 扣减库存
     */
    ObjectResponse decreaseStock(CommodityDTO commodityDTO);
}
