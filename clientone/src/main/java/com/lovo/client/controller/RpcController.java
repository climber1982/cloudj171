package com.lovo.client.controller;

import com.lovo.client.entity.UserEntity;
import com.lovo.client.service.IUserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
   @HystrixCommand(fallbackMethod = "error")
    public UserEntity getUser(@PathVariable int tag){
         int i=1/0;
       UserEntity user=new UserEntity();
       if(tag==0){
           user.setUserName("赵云");
       }else {
           user.setUserName("张飞");
       }
       return  user;
    }

    public UserEntity error(@PathVariable int tag){
        System.out.println(tag);
        UserEntity user=new UserEntity();
        user.setUserName("error");
        return user;
    }
    @RequestMapping("findUserByName")
    public UserEntity findUserByName(@RequestBody UserEntity userEntity){
      return     userService.findUserByName(userEntity.getUserName());
    }


}
