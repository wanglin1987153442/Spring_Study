package com.Spring_Study.web.controller;

import com.Spring_Study.web.service.PostService;
import com.Spring_Study.web.util.ResponseObject;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wl
 * @ClassNamePostController
 * @Description TODO
 * @Date 2020/3/20
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "post")
public class PostController {
    @Autowired
    private PostService postService;
@RequestMapping(value = "/{id}",produces = "application/json;charset=utf-8")
    public String getPost(@PathVariable(value = "id") Integer id){
    ResponseObject ro = new ResponseObject(1,"成功",postService.selectPostById(id));
    return JSON.toJSONString(ro);
}
}
