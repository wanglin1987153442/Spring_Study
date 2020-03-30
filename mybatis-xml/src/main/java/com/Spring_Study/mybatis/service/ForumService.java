package com.Spring_Study.mybatis.service;


import com.Spring_Study.mybatis.entity.Forum;

import java.util.List;

/**
 * @author wl
 * @ClassNameasda
 * @Description TODO
 * @Date 2020/3/29
 * @Version 1.0
 */
public interface ForumService {


    /**
     * 新增实体
     * @param forum
     */
    void insert(Forum forum);

    /**
     * 根据id删除
     * @param id
     */
    void delete(int id);

    /**
     * 修改
     * @param forum
     */
    void update(Forum forum);

    /**
     * 查询所有
     * @return
     */
    List<Forum> selectAll();

    /**
     * 根据id查询Forum
     * @param id
     * @return Forum
     */
    Forum selectForumById(int id);
}