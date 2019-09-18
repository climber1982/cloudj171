package com.lovo.client.service;

import com.lovo.client.entity.UserEntity;

public interface IUserService {

    public UserEntity findUserByName(String userName);
}
