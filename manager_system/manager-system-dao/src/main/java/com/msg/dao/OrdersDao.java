package com.msg.dao;

import com.github.pagehelper.ISelect;
import com.msg.domain.Member;
import com.msg.domain.Orders;
import com.msg.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/11 11:13
 */

@Repository
public interface OrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.msg.dao.ProductDao.findOneProductById"))
            })
    public List<Orders> findAllOrders();

    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.msg.dao.ProductDao.findOneProductById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.msg.dao.MemberDao.findOneMemberById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "com.msg.dao.TravellerDao.findTravellersByOrdersId"))
    })
    public Orders findOneOrderById(String id);
}
