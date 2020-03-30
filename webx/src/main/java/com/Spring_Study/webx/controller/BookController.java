package com.Spring_Study.webx.controller;

import com.Spring_Study.webx.service.BookService;
import org.apache.regexp.RE;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author wl
 * @ClassNameBookController
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 */
@Controller
@RequestMapping(value = {"/"})
public class BookController {
    @Resource
   private BookService bookService;
    @GetMapping(value = "/book",produces = "application/json;charset=utf-8")
    public  String book(Model model){
        model.addAttribute("books" ,bookService.selectAll());
        return "book";
    }

}
