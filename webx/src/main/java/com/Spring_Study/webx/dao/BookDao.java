package com.Spring_Study.webx.dao;

import com.Spring_Study.webx.entity.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * @author wl
 * @ClassNameBookDao
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 */
public interface BookDao {
    /**
     * 批量插入数据
     * @return
     * @throws SQLException
     */
    int[] bathinsertBook(List<Book> list)throws SQLException;

    /**
     * 插入图书
     * @param book
     * @return
     * @throws SQLException
     */
    int insertBook(Book book)throws SQLException;
    /**
     * 查询书籍
     *
     * @return
     * @throws SQLException
     */
    List<Book> selectAll()throws  SQLException;
}
