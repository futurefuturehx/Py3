package controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
@Controller
    //Z:RequsetMapping作用在类上 相当于给该类的所有配置的映射地址前加上一个地址
public class test{
    @RequestMapping("/param")
/*    public ModelAndView getParam(HttpServletRequest request,
                                 HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        System.out.println(userName);
        System.out.println(password);
        return null;
    }*/
    //Z:这样写 减少与前台的耦合
/*    public ModelAndView getParam(@RequestParam("userName") String userName,
                                 @RequestParam("password") String password) {
        System.out.println(userName);
        System.out.println(password);
        return null;
    }*/

    //Z:或者使用bean直接这么写 直接写入读取User对象
    //Z:bean就好比是传递的字节流 return mav也就相当于 准备好数据 跳转到页面
    public ModelAndView getParam(User user) {
        ModelAndView mav = new ModelAndView("output");
        mav.addObject("userName", user.getUserName());
        mav.addObject("passWord", user.getPassword());
        return mav;
    }
}