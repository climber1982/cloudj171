package com.lovo.cilent.controller;

import com.lovo.cilent.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MessageController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("getRPCMessage")
    public String getRPCMessage(){
        //进行远程调用
      String str=  restTemplate.getForEntity("http://clientone/rpcMessage",String.class).getBody();
    return  str;
    }

    @RequestMapping("getUser")
    public String getUser(){
        UserEntity user=      restTemplate.getForEntity("http://clientone/user/0", UserEntity.class).getBody();
        System.out.println(user.getUserName());
         return "ok";
    }
     @RequestMapping("postUser")
    public  String postUser(){
      UserEntity userEntity=new UserEntity();
      userEntity.setUserName("赵云2");
         UserEntity user=  restTemplate.postForEntity("http://clientone/findUserByName",userEntity,UserEntity.class).getBody();
         System.out.println(user.getUserName());
         return "ok";
    }
}
