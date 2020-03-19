package com.Spring_Study.orm.dao;


import com.Spring_Study.orm.com.config.JDBCConfig;
import com.Spring_Study.orm.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JDBCConfig.class})
//@ContextConfiguration(locations = {"/applicationContext.xml"})
public class PostDaoTest {
    @Autowired
    private PostDao postDao;
    @Test
    public void insert() {

        Timestamp timestamp  =  Timestamp.valueOf(LocalDateTime.now());
        Post post= Post.builder().forumId(1).title("测试1").content("1").thumbnail("11").createTime(timestamp).build();
        int n =postDao.insert(post);
        assertEquals(1,n);
    }

    @Test
    public void bathInsert() {
        Timestamp timestamp  =  Timestamp.valueOf(LocalDateTime.now());
        Post[]posts={Post.builder().forumId(2).title("post2").content("2").thumbnail("22").createTime(timestamp).build(),
                Post.builder().forumId(3).title("post3").content("3").thumbnail("33").createTime(timestamp).build(),
                Post.builder().forumId(4).title("post4").content("4").thumbnail("44").createTime(timestamp).build(),
                Post.builder().forumId(5).title("post5").content("5").thumbnail("55").createTime(timestamp).build(),
        };
        List<Post> postList= Arrays.asList(posts);
        int[]rows =postDao.bathInsert(postList);
        assertEquals(4,rows.length);
    }

    @Test
    public void delete() {
        int n =postDao.delete(1);
        assertEquals(1,n);
    }

    @Test
    public void update() {
        Post post= postDao.get(5);
        System.out.println(post);
        post.setTitle("修改post1");
        int n =postDao.update(post);
        assertEquals(1,n);
    }

    @Test
    public void get() {
        Post post =postDao.get(2);
        System.out.println(post);
        assertNotNull(post);
    }

    @Test
    public void selectAll() {
        List<Post> postList =postDao.selectAll();
        postList.forEach(System.out::println);
    }

    @Test
    public void selectByKey() {
        postDao.selectByKey("2").forEach(System.out::println);
    }
    @Test
    public void count() {
        int n = postDao.count();
        System.out.println(n);
    }

    @Test
    public void batchDelete() {
        Post[]posts={Post.builder().postId(2).build(),Post.builder().postId(3).build()};
        List<Post>postList= Arrays.asList(posts);
        int[]rows =postDao.batchDelete(postList);
        assertEquals(2,rows.length);
    }



}