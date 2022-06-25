package com.dewen.product.service.impl;

import com.dewen.product.mapper.ProductMapper;
import com.dewen.product.service.IProduct;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class ProductService implements IProduct {

    @Resource
    private ProductMapper productMapper;

    /**
     * 进库存，加预扣
     *
     * @param productId
     * @param count
     */
    @Override
    public void decrease(Long productId, Integer count) {
        productMapper.minusStockAndAddWithholdingStock(productId, count);
        log.info("预扣");
    }

    /**
     * 减预扣
     *
     * @param context 上下文
     * @return
     */
    @Override
    public boolean commit(BusinessActionContext context) {
        log.info(context.getActionName() + ",xid-" + context.getXid() + "二阶段提交");
        Long productId = Long.valueOf(String.valueOf(context.getActionContext("productId")));
        Integer count = Integer.valueOf(String.valueOf(context.getActionContext("count")));
        productMapper.minusWithholdingStock(productId, count);
        return true;
    }

    /**
     * 减预扣，加库存
     *
     * @param context 上下文
     * @return
     */
    @Override
    public boolean rollback(BusinessActionContext context) {
        log.info("xid-" + context.getXid() + "二阶段回滚");
        Long productId = Long.valueOf(String.valueOf(context.getActionContext("productId")));
        Integer count = Integer.valueOf(String.valueOf(context.getActionContext("count")));
        productMapper.addStockAndMinusWithholdingStock(productId, count);
        return true;
    }
}
