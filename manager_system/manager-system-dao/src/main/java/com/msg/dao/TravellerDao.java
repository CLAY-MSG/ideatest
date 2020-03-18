package com.msg.dao;

import com.msg.domain.Member;
import com.msg.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/11 11:13
 */

@Repository
public interface TravellerDao {

    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId = #{id})")
    List<Traveller> findTravellersByOrdersId(String id);
}
