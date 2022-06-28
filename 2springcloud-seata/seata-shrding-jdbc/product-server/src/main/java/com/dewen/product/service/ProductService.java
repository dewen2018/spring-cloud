package com.dewen.product.service;

import com.dewen.product.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ProductService {

    @Resource
    private ProductMapper productMapper;

    @Transactional
    public void minusStock(Long productId, Integer count) {
        productMapper.minusStock(productId, count);
    }
}
