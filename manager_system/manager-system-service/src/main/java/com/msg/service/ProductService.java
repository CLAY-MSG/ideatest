package com.msg.service;

import com.msg.domain.Product;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/2/24 17:13
 */
public interface ProductService {
    /**
     * 查询所有产品信息
     * @return
     */
    List<Product> findAllProduct();

    void saveProduct(Product product) throws Exception;
}
