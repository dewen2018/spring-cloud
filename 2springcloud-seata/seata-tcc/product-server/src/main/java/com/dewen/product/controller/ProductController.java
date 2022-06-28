package com.dewen.product.controller;

import com.dewen.product.service.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private IProduct productService;

    @PutMapping("/minus/stock")
    public ResponseEntity<Void> minusStock(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        productService.decrease(productId, count);
        // int a = 1 / 0;
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
