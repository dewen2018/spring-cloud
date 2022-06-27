package com.dewen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dewen.dto.CommodityDTO;
import com.dewen.entity.TStock;
import com.dewen.enums.RspStatusEnum;
import com.dewen.mapper.TStockMapper;
import com.dewen.response.ObjectResponse;
import com.dewen.service.ITStockService;
import org.springframework.stereotype.Service;


@Service
public class TStockServiceImpl extends ServiceImpl<TStockMapper, TStock> implements ITStockService {

    @Override
    public ObjectResponse decreaseStock(CommodityDTO commodityDTO) {
        int stock = baseMapper.decreaseStock(commodityDTO.getCommodityCode(), commodityDTO.getCount());
        ObjectResponse<Object> response = new ObjectResponse<>();
        if (stock > 0) {
            response.setStatus(RspStatusEnum.SUCCESS.getCode());
            response.setMessage(RspStatusEnum.SUCCESS.getMessage());
            return response;
        }

        response.setStatus(RspStatusEnum.FAIL.getCode());
        response.setMessage(RspStatusEnum.FAIL.getMessage());
        return response;
    }
}
