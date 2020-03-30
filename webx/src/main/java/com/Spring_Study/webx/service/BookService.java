package com.Spring_Study.webx.service;

import com.Spring_Study.webx.entity.Book;
import com.Spring_Study.webx.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.jdbc.Sql;

import javax.annotation.Resource;

import java.util.List;

/**
 * @author wl
 * @ClassNameBookService
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 */
public interface BookService {


   /**
    * 查询所有
    * @return
    */
   List<Book> selectAll();
}
