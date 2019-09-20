package com.lovo.user.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lovo.user.dao.IUserDao;
import com.lovo.user.entity.UserEntity;
import com.lovo.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @JmsListener(destination = "userQueue")
    public void savaUser(String userJson) throws IOException {
        //获得MQ里面的用户信息
        ObjectMapper obj=new ObjectMapper();
      UserEntity user=   obj.readValue(userJson,UserEntity.class);
        //把MQ里的用户保存到服务器
        userDao.save(user);
    }

    @Override
    public UserEntity findUser(UserEntity user) {
        return userDao.login(user.getUserName(),user.getPassword());
    }
}
