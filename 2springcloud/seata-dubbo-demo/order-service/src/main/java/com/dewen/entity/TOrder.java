package com.dewen.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
public class TOrder extends Model<TOrder> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String orderNo;
    private String userId;
    private String commodityCode;
    private Integer count;
    private Double amount;


    @Override
    public String toString() {
        return "TOrder{" + ", id=" + id + ", orderNo=" + orderNo + ", userId=" + userId + ", commodityCode="
                + commodityCode + ", count=" + count + ", amount=" + amount + "}";
    }
}
