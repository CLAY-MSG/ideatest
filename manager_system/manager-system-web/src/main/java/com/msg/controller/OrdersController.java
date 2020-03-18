package com.msg.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msg.domain.Orders;
import com.msg.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/9 14:33
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    //    未分页
    /*@RequestMapping("/findAll")
    public String findAll(Model model){
        List<Orders> ordersList = ordersService.findAllOrders();
        model.addAttribute("ordersList",ordersList);
        return "orders-list";
    }*/

    /**
     * 使用PageHelper分页
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    @Secured("ROLE_ADMIN")
    public String findAll(Model model, @RequestParam(required = true,defaultValue = "1") Integer pageCurrent, @RequestParam(required = true,defaultValue = "5") Integer pageSize){
        List<Orders> ordersList = ordersService.findAllOrders(pageCurrent,pageSize);
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);
        model.addAttribute("pageInfo",pageInfo);
        return "orders-list";
    }

    @RequestMapping("/findById")
    public String findById(Model model,String id){
        Orders orders = ordersService.findOneOrderById(id);
        model.addAttribute("orders",orders);
        return "orders-show";
    }

    /*@RequestMapping("/save")
    public String saveProduct(Product product) throws Exception{
        productService.saveProduct(product);
        return "redirect:findAll";
    }*/
}
