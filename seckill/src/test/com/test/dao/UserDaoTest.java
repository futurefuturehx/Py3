package com.test.dao;

import com.test.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration用来指定配置文件目录 也就是主配置文件 包括了mybatis配置
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {
    //@Autowired用于自动连接bean
    @Autowired(required = false)
    private UserDao userDao;

    //实体类就成了基本的传输流 类似于一条记录 主要用于增加和修改
    @Test
    public void addUser() throws Exception {
        User user = new User();
        user.setId(1);
        user.setName("hx");
        user.setPasswd("060412hx");
        user.setAppid("10524784526");
        userDao.addUser(user);
    }

    @Test
    public void findByAppid() throws Exception {
        //实现写在了xml文件中
        System.out.println("userDao="+userDao);
        User user = userDao.findByAppid("10524782571");
        System.out.println(user);
    }

    @Test
    public void deleteById() throws Exception {
        userDao.deleteById(11);
        System.out.println("删除成功");
    }

}