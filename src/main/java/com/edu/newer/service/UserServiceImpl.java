package com.edu.newer.service;

import com.edu.newer.dao.UserDao;
import com.edu.newer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * @author XW
 * @create 2022-02-21 21:46
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        User userDB = userDao.login(user);
        System.out.println(userDB);
       if(!ObjectUtils.isEmpty(userDB)){
           return userDB;
       }else {
           throw  new RuntimeException("登录失败");
       }
    }
}
