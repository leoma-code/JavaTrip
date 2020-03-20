package com.leo.controller;

import com.leo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Leo on 2020/3/20.
 * Description :
 */

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("testString")
    public String testString(Model model) {
        System.out.println("testString....");

        User user = new User();
        user.setUsername("张三");
        user.setAge(18);
        model.addAttribute("user", user);

        return "success";
    }


    @RequestMapping(value = "testAjax" )
    @ResponseBody
    public User testAjax(@RequestBody User user) {


        System.out.println(user);

        user.setUsername("李四");
        user.setAge(20);

        return user;

    }


}
