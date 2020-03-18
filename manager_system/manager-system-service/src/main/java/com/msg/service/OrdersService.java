package com.msg.service;

import com.msg.domain.Orders;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/11 11:10
 */
public interface OrdersService {

    public List<Orders> findAllOrders(Integer pageCurrent, Integer pageSize);

    Orders findOneOrderById(String id);
}
