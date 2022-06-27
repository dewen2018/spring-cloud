package com.dewen.controller;

import com.dewen.dto.CommodityDTO;
import com.dewen.response.ObjectResponse;
import com.dewen.service.ITStockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
@Slf4j
public class TStockController {

    @Autowired
    private ITStockService stockService;

    /**
     * 扣减库存
     */
    @PostMapping("dec_stock")
    ObjectResponse decreaseStock(@RequestBody CommodityDTO commodityDTO) {
        log.info("请求库存微服务：{}", commodityDTO.toString());
        return stockService.decreaseStock(commodityDTO);
    }
}

