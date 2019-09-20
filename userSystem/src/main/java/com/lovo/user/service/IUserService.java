package com.lovo.user.service;

import com.lovo.user.entity.UserEntity;

import java.io.IOException;

public interface IUserService {
    /**
     * 保存用户
     */
    public void savaUser(String userJson) throws IOException;

    /**
     * 查询用户是否存在
     * @param user
     * @return
     */
    public UserEntity findUser(UserEntity user);
}
