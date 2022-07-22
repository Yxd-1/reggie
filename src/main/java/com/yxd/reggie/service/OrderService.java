package com.yxd.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yxd.reggie.entity.Orders;

public interface OrderService extends IService<Orders> {

    /**
     * 用户下单
     * @param orders
     */
    void submit(Orders orders);
}
