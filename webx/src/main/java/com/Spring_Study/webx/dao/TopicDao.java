package com.Spring_Study.webx.dao;

import com.Spring_Study.webx.entity.Topic;

import java.util.List;

/**
 * @author wl
 * @ClassNameTopicDap
 * @Description TODO
 * @Date 2020/3/26
 * @Version 1.0
 */
public interface TopicDao {
    List<Topic> selectAll();
}
