package com.Spring_Study.webx.dao.impl;

import com.Spring_Study.webx.config.JDBCConfig;
import com.Spring_Study.webx.dao.BookDao;
import com.Spring_Study.webx.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wl
 * @ClassNameBookDaoImpl
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int[] bathinsertBook(List<Book>list) throws SQLException {
        String sql= "INSERT INTO t_book(sku_id,type,description,title,url,cover,book_size,name,price) values(?,?,?,?,?,?,?,?,?)";
      return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
          @Override
          public void setValues(PreparedStatement ps, int i) throws SQLException {
              ps.setString(1,list.get(i).getSkuId());
              System.out.println(list.get(i).getSkuId());
              ps.setString(2,list.get(i).getType());
              ps.setString(3,list.get(i).getDescription());
              ps.setString(4,list.get(i).getTitle());
              ps.setString(5,list.get(i).getUrl());
              ps.setString(6,list.get(i).getCover());
              ps.setLong(7,list.get(i).getBookSize());
              ps.setString(8,list.get(i).getName());
              ps.setString(9,list.get(i).getPrice());


          }

          @Override
          public int getBatchSize() {
              return list.size();

          }
      });
    }

    @Override
    public int insertBook(Book book) throws SQLException {
        String sql= "INSERT INTO t_book(sku_id,type,description,title,url,cover,book_size,name,price) values(?,?,?,?,?,?,?,?,?)";
        Object[] args={book.getSkuId(),book.getType(), book.getDescription(), book.getTitle(), book.getUrl(), book.getCover(), book.getBookSize(),book.getName(), book.getPrice()};
        return jdbcTemplate.update(sql,args);
    }

    @Override
    public List<Book> selectAll() throws SQLException {
        String sql="SELECT * from t_book  GROUP BY sku_id\n";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Book.class));
    }
}
