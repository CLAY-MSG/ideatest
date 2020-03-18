package com.msg.service.impl;

import com.github.pagehelper.PageHelper;
import com.msg.dao.OrdersDao;
import com.msg.domain.Orders;
import com.msg.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/11 11:11
 */

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersDao ordersDao;

    @Override
    public List<Orders> findAllOrders(Integer pageCurrent, Integer pageSize) {
        PageHelper.startPage(pageCurrent,pageSize);
        return ordersDao.findAllOrders();
    }

    @Override
    public Orders findOneOrderById(String id) {
        return ordersDao.findOneOrderById(id);
    }
}
