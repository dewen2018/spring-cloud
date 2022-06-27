package com.dewen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dewen.entity.TStock;
import org.apache.ibatis.annotations.Param;

public interface TStockMapper extends BaseMapper<TStock> {

    /**
     * 扣减商品库存
     *
     * @Param: commodityCode 商品code  count扣减数量
     * @Return:
     */
    int decreaseStock(@Param("commodityCode") String commodityCode, @Param("count") Integer count);
}
