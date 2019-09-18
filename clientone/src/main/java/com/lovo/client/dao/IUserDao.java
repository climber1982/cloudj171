package com.lovo.client.dao;

import com.lovo.client.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<UserEntity,String> {
    @Query("from UserEntity  where userName=?1")
    public UserEntity findUserByName(String userName);
}
