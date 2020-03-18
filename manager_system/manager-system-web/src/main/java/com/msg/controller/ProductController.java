package com.msg.controller;

import com.msg.domain.Product;
import com.msg.service.ProductService;
import com.msg.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.Date;
import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/9 14:33
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/findAll")
    @RolesAllowed("ADMIN")
    public String findAll(Model model){
        List<Product> productList = productService.findAllProduct();
        model.addAttribute("productList",productList);
        return "product-list";
    }

    @RequestMapping("/save")
    public String saveProduct(Product product) throws Exception{
        productService.saveProduct(product);
        return "redirect:findAll";
    }
}
