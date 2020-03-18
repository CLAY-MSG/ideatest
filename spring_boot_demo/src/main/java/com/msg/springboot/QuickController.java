package com.msg.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/17 9:49
 */

@Controller
public class QuickController {

    @RequestMapping("/quick")
    public @ResponseBody String quickStart(){
        return "hello!123456789101010";
    }
}
