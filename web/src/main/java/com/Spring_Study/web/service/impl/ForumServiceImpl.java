package com.Spring_Study.web.service.impl;



import com.Spring_Study.web.dao.ForumDao;
import com.Spring_Study.web.entity.Forum;
import com.Spring_Study.web.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wl
 * @className ForumServiceImpl
 * @Description TODO
 * @Date 2020/3/20 13:58
 * @Version 1.0
 **/
@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumDao forumDao;
    @Override
    public List<Forum> selectAll() {
        return forumDao.selectAll();
    }
}
