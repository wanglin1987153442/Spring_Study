package com.Spring_Study.webx.dao;

import com.Spring_Study.webx.config.JDBCConfig;
import com.Spring_Study.webx.entity.Book;
import com.Spring_Study.webx.util.FastJson_zhihu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.annotation.Resource;
import javax.ejb.TransactionManagement;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JDBCConfig.class})
@WebAppConfiguration("src/main/resources")
@Transactional(rollbackFor = Exception.class)
public class BookDaoTest {
@Resource
BookDao bookDao;
    @Test
    public void bathinsertBook() {
       List<Book> list= FastJson_zhihu.getData();
        try {
            bookDao.bathinsertBook(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void insertBook() {
        Book book=Book.builder().price("12").name("WA").bookSize(525).cover("WWA").url("WAWA").title("IXIXIX")
                .description("WDADW").type("EB").skuId("213132").build();
        try {
            int n =bookDao.insertBook(book);
            System.out.println(1111111111);
            System.out.println(n);
            int y=1/0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}