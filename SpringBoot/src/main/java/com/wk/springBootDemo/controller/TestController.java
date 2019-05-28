package com.wk.springBootDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class TestController {
    //映射该地址
    @RequestMapping("/test/a.do")
    //@ResponseBody将对象转化为指定格式 传递到前端
    @ResponseBody
    public String a(){
        return "a";
    }

    //映射根地址
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

}
