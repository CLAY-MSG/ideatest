package com.msg.service.impl;

import com.msg.dao.ProductDao;
import com.msg.domain.Product;
import com.msg.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/2/24 17:13
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;


    @Override
    public List<Product> findAllProduct() {
        return productDao.findAllProduct();
    }

    @Override
    public void saveProduct(Product product) throws Exception{
        System.out.println(product);
        productDao.saveProduct(product);
    }
}
