package com.lovo.client.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "sys_user")
public class UserEntity {
    @Id
    @GenericGenerator(name = "uuuuid",strategy = "uuid")
    @GeneratedValue(generator = "uuuuid")
    @Column(length = 32,name = "u_id")
    private  String userId;
    @Column(length = 48)
    private String userName;
  //  @JsonIgnore
    @Column(length = 48)
    private String password;
    @Column(length = 128)
    private  String filePath;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
