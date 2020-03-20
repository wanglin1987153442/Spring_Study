package com.Spring_Study.web.service;

import com.Spring_Study.web.entity.Post;

/**
 * @author wl
 * @ClassNamePostService
 * @Description TODO
 * @Date 2020/3/20
 * @Version 1.0
 */
public interface PostService {
    /**
     * 根据id查询帖子
     * @return
     */
    Post selectPostById(Integer id);
}
