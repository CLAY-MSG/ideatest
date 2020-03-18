package com.msg.dao;

import com.msg.domain.Member;
import com.msg.domain.Orders;
import com.msg.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/11 11:13
 */

@Repository
public interface MemberDao {

    @Select("select * from member where id = #{id}")
    Member findOneMemberById(String id);
}
