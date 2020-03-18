package com.example.springboot_maven_demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/17 10:09
 */
@RestController
public class QuickControllers {

    @RequestMapping("/quick2")
    public String quick(){
        return "hello1680";
    }
}
