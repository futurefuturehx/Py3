package com.test.dao;

import com.test.entity.User;

/**
 * DAO接口,mybatis动态完成Impl
 */
//类似于一个todo mybatis会自动完成Impl
public interface UserDao {

    Integer addUser(User u);

    User findByAppid(String appid);

    User findById(Integer id);

    Integer deleteById(Integer id);
}
