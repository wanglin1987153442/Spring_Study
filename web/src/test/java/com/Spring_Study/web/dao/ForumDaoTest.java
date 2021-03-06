package com.Spring_Study.web.dao;

import com.Spring_Study.web.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ForumDaoTest {

    @Autowired
    private ForumDao forumDao;

    @Test
    public void selectAll() {
        List<Forum> forumList = forumDao.selectAll();
        forumList.forEach(System.out::println);
    }
}