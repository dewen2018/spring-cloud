package com.dewen.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dewen.product.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface ProductMapper extends BaseMapper<Product> {

    @Update("update product_info set stock = stock - #{count},withholding_stock = withholding_stock + #{count} where id = #{productId}")
    void minusStockAndAddWithholdingStock(@Param("productId") Long productId, @Param("count") Integer count);

    @Update("update product_info set withholding_stock = withholding_stock - #{count} where id = #{productId}")
    void minusWithholdingStock(@Param("productId") Long productId, @Param("count") Integer count);

    @Update("update product_info set stock = stock + #{count},withholding_stock = withholding_stock - #{count} where id = #{productId}")
    void addStockAndMinusWithholdingStock(@Param("productId") Long productId, @Param("count") Integer count);
}
