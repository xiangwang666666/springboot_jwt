package com.edu.newer.dao;

import com.edu.newer.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author XW
 * @create 2022-02-21 21:40
 */
@Mapper
public interface UserDao {
  User login(User user);
}
