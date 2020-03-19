package com.Spring_Study.orm.dao;


import com.Spring_Study.orm.entity.Post;

import java.util.List;

/**
 * @author wl
 * @className PostDao
 * @Description TODO
 * @Date 2020/3/17 19:08
 * @Version 1.0
 **/
public interface PostDao {
    /**
     * 插入数据
     * @param post
     * @return
     */
    int insert(Post post);

    /**
     * 批量插入数据
     * @param posts
     * @return
     */
    int[] bathInsert(List<Post> posts);

    /**
     * 根据id删除post
     * @param postId
     * @return
     */
    int delete(int postId);

    /**
     * 修改post
     * @param post
     * @return
     */
    int update(Post post);

    /**
     * 根据id查询post
     *
     * @param postId
     * @return
     */
    Post get(int postId);

    /**
     * 查询所有帖子
     * @return
     */
    List<Post>selectAll();


    List<Post>selectByKey(String key);

    int count();

    int[] batchDelete(List<Post> posts);


}
