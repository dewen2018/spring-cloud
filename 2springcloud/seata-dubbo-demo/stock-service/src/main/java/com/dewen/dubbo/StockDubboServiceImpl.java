package com.dewen.dubbo;

import com.dewen.dto.CommodityDTO;
import com.dewen.response.ObjectResponse;
import com.dewen.service.ITStockService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService(version = "1.0.0", protocol = "${dubbo.protocol.id}", application = "${dubbo.application.id}", registry = "${dubbo.registry.id}", timeout = 3000)
@Slf4j
public class StockDubboServiceImpl implements StockDubboService {

    @Autowired
    private ITStockService stockService;

    @Override
    public ObjectResponse decreaseStock(CommodityDTO commodityDTO) {
        log.info("全局事务id ：" + RootContext.getXID());
        return stockService.decreaseStock(commodityDTO);
    }
}
