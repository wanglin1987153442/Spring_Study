package com.Spring_Study.webx.dao.impl;

import com.Spring_Study.webx.dao.TopicDao;

import com.Spring_Study.webx.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wl
 * @ClassNameTopicDaoImpl
 * @Description TODO
 * @Date 2020/3/26
 * @Version 1.0
 */
@Repository
public class TopicDaoImpl implements TopicDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Topic> selectAll() {
        String sql = "SELECT * FROM t_topic";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Topic.class));

    }
}
