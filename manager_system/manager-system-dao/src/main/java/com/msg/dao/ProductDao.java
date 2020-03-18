package com.msg.dao;

import com.msg.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/2/24 17:14
 */
@Repository
public interface ProductDao {

    @Select("select * from product where id = #{id}")
    Product findOneProductById(String id);

    @Select("select * from product")
    List<Product> findAllProduct();

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void saveProduct(Product product) throws Exception;

}
