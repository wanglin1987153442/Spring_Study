package com.Spring_Study.hibernate.dao;

import com.Spring_Study.hibernate.entity.User;

import java.util.List;

/**
 * @author wl
 * @ClassNameUserDao
 * @Description TODO
 * @Date 2020/4/1
 * @Version 1.0
 */
public interface UserDao {
    /**
     * 新增
     *
     * @param user
     */
    void insertUser(User user);

    /**
     * 删除
     *
     * @param user
     */
    void deleteUser(User user);

    /**
     * 删除
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 按主键查
     *
     * @param userId
     * @return
     */
    User getUser(Integer userId);

    /**
     * 查所有
     *
     * @return
     */
    List<User> selectAll();
}
