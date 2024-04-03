package com.cy.store.service.impl;

import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public void reg(User user) {
        String username = user.getUsername();

        User result = userMapper.findByUserName(username);
        if (result != null){
            throw new UsernameDuplicatedException("用户名被占用");
        }
        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        //密码加密
        String oldPassword = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();
        String md5Password = getMd5Password(oldPassword, salt);
        user.setSalt(salt);
        //加密密码设置到user中
        user.setPassword(md5Password);


        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        Integer rows = userMapper.insert(user);
        if (rows != 1){
            throw new InsertException("在用户注册过程中产生了未知异常");

        }


    }
    private String getMd5Password(String password,String salt){
        //md5算法的加密处理
        for (int i = 0; i < 3; i++) {
           password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
