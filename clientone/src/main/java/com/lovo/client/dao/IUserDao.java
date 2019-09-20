package com.lovo.client.dao;

import com.lovo.client.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserDao extends CrudRepository<UserEntity,String> {
    @Query("from UserEntity  where userName=?1")
    public UserEntity findUserByName(String userName);

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    @Query("from UserEntity where userName=?1 and password=?2")
    public UserEntity  loginUser(String userName,String password);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    @Query("from UserEntity ")
    public List<UserEntity> findUserPage(Pageable pageable);
}
