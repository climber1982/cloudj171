package com.lovo.client.controller;

import com.lovo.client.entity.UserEntity;
import com.lovo.client.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
   @Autowired
    private IUserService userService;
  @Autowired
   private RestTemplate restTemplate;

    @RequestMapping("registerUser")
    public String registerUser(UserEntity user){
        try {
            userService.savaUser(user);
        }catch (Exception e){
            return "{'result':false}";
        }
        //向MQ发送注册信息

    return "{'result':true}";
    }
@RequestMapping("loginUser")
    public String loginUser(UserEntity user2, HttpServletRequest request){
      UserEntity   user=    userService.loginUser(user2);

        if(null!=user){
            //登录成功后把数据放入到session
            request.getSession().setAttribute("user",user);
            return "{'result':true}";
        }else {
            //如果用户不存在，就去远程查询
           user= restTemplate.postForEntity("http://usersystem/getUser",user2,UserEntity.class).getBody();
           if(null!=user){
               request.getSession().setAttribute("user",user);
               return "{'result':true}";
           }else {
               return "{'result':false}";
           }
        }

    }
  @RequestMapping("showuser")
    public Map<String,Object> showuser(int page,int rows){
        page=page-1;
        Map<String,Object> map=new HashMap<>();
    List<UserEntity> pages= userService.findUserPage(page,rows);
        map.put("page",page);
        map.put("rows",pages);

        map.put("total",10);
        return map;
    }
    @RequestMapping("isLogin")
    public String isLogin(HttpServletRequest request){
     Object obj=   request.getSession().getAttribute("user");
     if(null==obj){
         return "{'result':false}";
     }
        return "{'result':true}";
    }
}
