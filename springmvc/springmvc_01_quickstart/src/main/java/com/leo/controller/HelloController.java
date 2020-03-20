package com.leo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Leo on 2020/3/20.
 * Description :
 */

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hello")
    public String quickstart(String username) {
        System.out.println("快速入门。。。。。");
        System.out.println(username);
        return "success";
    }


}
