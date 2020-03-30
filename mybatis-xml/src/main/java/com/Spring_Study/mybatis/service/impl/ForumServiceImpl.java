package com.Spring_Study.mybatis.service.impl;

import com.Spring_Study.mybatis.entity.Forum;
import com.Spring_Study.mybatis.mapper.ForumMapper;
import com.Spring_Study.mybatis.service.ForumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wl
 * @ClassNamesda
 * @Description TODO
 * @Date 2020/3/30
 * @Version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ForumServiceImpl implements ForumService {
    @Resource
    private ForumMapper forumMapper;

    @Override
    public void insert(Forum forum) {
        forumMapper.insert(forum);
    }

    @Override
    public void delete(int id) {
        forumMapper.delete(id);
    }

    @Override
    public void update(Forum forum) {
        forumMapper.update(forum);
    }

    @Override
    public List<Forum> selectAll() {
        return forumMapper.selectAll();
    }

    @Override
    public Forum selectForumById(int id) {
        return forumMapper.selectForumById(id);
    }
}