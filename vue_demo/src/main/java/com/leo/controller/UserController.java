package com.leo.controller;

import com.leo.domain.User;
import com.leo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Leo on 2020/4/3.
 * Description :
 */


@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return  userService.findAll();
    }


    @RequestMapping("/findById")
    public User findById(Integer id) {
        System.out.println("userID -- " + id);
        return  userService.findById(id);
    }

    @RequestMapping("/updateUser")
    public void updateUser(@RequestBody  User user) {
        userService.updateUser(user);
    }

}
