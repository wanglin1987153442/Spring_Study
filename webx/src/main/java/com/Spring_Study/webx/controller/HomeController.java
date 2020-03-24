package com.Spring_Study.webx.controller;


import com.Spring_Study.webx.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.ArrayList;
import java.util.List;

/**
 * @author wl
 * @ClassNameHomeController
 * @Description TODO
 * @Date 2020/3/24
 * @Version 1.0
 */
@Controller
public class HomeController {
@GetMapping("/")
    public String home(Model model){
    model.addAttribute("message","hello1111");

    List<Book> list=new ArrayList<>();
    Book book1 =new Book();
    book1.setName("明天你好");
    book1.setPrice(25.89);

    Book book2 =new Book();
    book2.setName("明天你很好");
    book2.setPrice(52.89);
    list.add(book1);
    list.add(book2);

    model.addAttribute("bookList",list );

    return "home";
}
}
