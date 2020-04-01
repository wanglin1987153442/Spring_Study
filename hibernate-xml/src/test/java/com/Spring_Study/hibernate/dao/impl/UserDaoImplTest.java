package com.Spring_Study.hibernate.dao.impl;

import com.Spring_Study.hibernate.dao.UserDao;
import com.Spring_Study.hibernate.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-hibernate.xml"})
public class UserDaoImplTest {
    @Resource
    private UserDao userDao;

    @Test
    public void insertUser() {
        User user =  User.builder().userName("Java").age(20).build();
        userDao.insertUser(user);
    }

    @Test
    public void deleteUser() {
        User user = User.builder().userId(2).build();
        userDao.deleteUser(user);
    }

    @Test
    public void updateUser() {
        User user = userDao.getUser(1);
        user.setUserName("hello");
        userDao.updateUser(user);
    }

    @Test
    public void getUser() {
        System.out.println(userDao.getUser(1));
    }

    @Test
    public void selectAll() {
        List<User> users =userDao.selectAll();
        System.out.println(users.size());
    }
}