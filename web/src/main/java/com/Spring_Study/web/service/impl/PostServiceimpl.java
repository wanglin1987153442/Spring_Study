package com.Spring_Study.web.service.impl;

import com.Spring_Study.web.dao.PostDao;
import com.Spring_Study.web.entity.Post;
import com.Spring_Study.web.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wl
 * @ClassNamePostServiceimpl
 * @Description TODO
 * @Date 2020/3/20
 * @Version 1.0
 */
@Service
public class PostServiceimpl implements PostService {
    @Autowired
    private PostDao postDao;
    @Override
    public Post selectPostById(Integer id) {

   return postDao.get(id);
    }
}
