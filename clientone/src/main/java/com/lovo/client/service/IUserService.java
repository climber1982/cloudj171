package com.lovo.client.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lovo.client.entity.UserEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService {

    public UserEntity findUserByName(String userName);

    /**
     * 注册用户
     * @param user
     */
    public void savaUser(UserEntity user) throws JsonProcessingException;

    /**
     * 登录
     * @param userEntity
     * @return
     */
    public UserEntity loginUser(UserEntity userEntity);

    /**
     * 分页展示用户
     * @return
     */
    public List<UserEntity> findUserPage(int startNum,int rows);

}
