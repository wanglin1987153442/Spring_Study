package com.Spring_Study.webx.service.serviceImpl;

import com.Spring_Study.webx.dao.BookDao;
import com.Spring_Study.webx.entity.Book;
import com.Spring_Study.webx.service.BookService;
import com.Spring_Study.webx.util.ResponseObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wl
 * @ClassNameBookServiceImpl
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BookServiceImpl implements BookService {

   @Resource
    BookDao bookDao;

    @Override
    public List<Book> selectAll() {
        List<Book> list = null;
        try {
       list=    bookDao.selectAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
