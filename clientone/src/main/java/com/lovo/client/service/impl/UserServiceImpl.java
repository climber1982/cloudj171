package com.lovo.client.service.impl;

import com.lovo.client.dao.IUserDao;
import com.lovo.client.entity.UserEntity;
import com.lovo.client.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {
   @Autowired
    private IUserDao userDao;

    public UserEntity findUserByName(String userName) {
        return userDao.findUserByName(userName);
    }
}
