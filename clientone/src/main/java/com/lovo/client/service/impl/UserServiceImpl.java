package com.lovo.client.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lovo.client.dao.IUserDao;
import com.lovo.client.entity.UserEntity;
import com.lovo.client.service.IUserService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {
   @Autowired
    private IUserDao userDao;
  @Autowired
   private JmsMessagingTemplate messagingTemplate;

    public UserEntity findUserByName(String userName) {
        return userDao.findUserByName(userName);
    }

    @Override
    public void savaUser(UserEntity user) throws JsonProcessingException {
        userDao.save(user);
        //放入远程的MQ
        ActiveMQQueue mqQueue=new ActiveMQQueue("userQueue");
        //把user对象转换为json
        ObjectMapper mapper=new ObjectMapper();
      String json=  mapper.writeValueAsString(user);
      //把json字符串放入到MQ
        messagingTemplate.convertAndSend(mqQueue,json);
    }

    @Override
    public UserEntity loginUser(UserEntity userEntity) {

        return userDao.loginUser(userEntity.getUserName(),userEntity.getPassword());
    }


    public List<UserEntity> findUserPage(int startNum,int rows) {
        Pageable p=PageRequest.of(startNum,rows);
        return  userDao.findUserPage(p);
    }
}
