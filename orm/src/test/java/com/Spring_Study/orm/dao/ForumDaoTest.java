package com.Spring_Study.orm.dao;


import com.Spring_Study.orm.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ForumDaoTest {

    @Autowired
    private ForumDao forumDao;

    @Test
    public void insert() {
        Forum forum = Forum.builder().forumName("测试").build();
        int n = forumDao.insert(forum);
        assertEquals(1, n);
    }

    @Test
    public void batchInsert() {
        Forum[] forums = {Forum.builder().forumName("论坛1").build(),
                Forum.builder().forumName("论坛2").build(),
                Forum.builder().forumName("论坛3").build()};
        List<Forum> forumList = Arrays.asList(forums);
        int[] rows = forumDao.batchInsert(forumList);
        assertEquals(3,rows.length);
    }

    @Test
    public void delete() {
        int n = forumDao.delete(1);
        assertEquals(1, n);
    }

    @Test
    public void update() {
        Forum forum = forumDao.get(1);
        forum.setForumName("修改论坛名称");
        int n = forumDao.update(forum);
        assertEquals(1, n);
    }

    @Test
    public void get() {
        Forum forum = forumDao.get(1);
        assertNotNull(forum);
    }



    @Test
    public void selectAll() {
        List<Forum> forums = forumDao.selectAll();
        assertEquals(4, forums.size());
    }
}