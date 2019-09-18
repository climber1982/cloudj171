package com.lovo.client.controller;

import com.lovo.client.entity.UserEntity;
import com.lovo.client.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class RpcController {
 @Autowired
    private IUserService userService;

   @RequestMapping("rpcMessage")
    public String rpcMessage(){
        return "hello cloud !!";
    }
   @RequestMapping("user/{tag}")
    public UserEntity getUser(@PathVariable int tag){

       UserEntity user=new UserEntity();
       if(tag==0){
           user.setUserName("赵云");
       }else {
           user.setUserName("张飞");
       }
       return  user;
    }
    @RequestMapping("findUserByName")
    public UserEntity findUserByName(@RequestBody UserEntity userEntity){
      return     userService.findUserByName(userEntity.getUserName());
    }


}
