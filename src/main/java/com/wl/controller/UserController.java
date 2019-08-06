package com.wl.controller;

import com.wl.entity.User;
import com.wl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private UserService userService;
        
        @RequestMapping(value = "login",method = RequestMethod.POST)
        @ResponseBody
        public User loginUser(String name, int password){
            User user = userService.loginUser(name,password);
            return user;
        }
        @RequestMapping(value ="register",method = RequestMethod.POST)
        @ResponseBody
        public String registerUser(User user){
            System.out.println("用户注册"+user.getUsername()+'\t'+user.getPassword());
            userService.registerUser(user);
            return "register success";
        }
}
