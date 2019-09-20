package com.lovo.user.controller;

import com.lovo.user.entity.UserEntity;
import com.lovo.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
   @Autowired
    private IUserService userService;
    @RequestMapping("getUser")
    public UserEntity getUser(@RequestBody  UserEntity user){
      user=  userService.findUser(user);
      return  user;
    }
}
