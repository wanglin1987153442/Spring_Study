package com.Spring_Study.webx.service;

import com.Spring_Study.webx.config.JDBCConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JDBCConfig.class})
@WebAppConfiguration("src/main/resources")
public class BookServiceTest {
@Resource
private BookService bookService;
    @Test
    public void selectAll() {

        System.out.println(

                bookService.selectAll()


        );
    }
}