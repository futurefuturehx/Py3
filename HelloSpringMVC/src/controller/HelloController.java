package controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
/*import org.springframework.web.servlet.mvc.Controller;*/
//信息传入处理
//指定渲染地址传出
//最初始的方式:
/*
public class HelloController implements Controller{
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("index.jsp");
        mav.addObject("message", "Hello Spring MVC");//将模型和视图关联起来
        return mav;
    }
}*/
//通过注解实现
//Controller注解声明控制器
//RequestMapping注解取代xml映射处理地址
//请求的是虚拟地址/hello 对于响应的地址进行页面变量替换index.jsp
@Controller
//RequsetMapping作用在类上 相当于给该类的所有配置的映射地址前加上一个地址
//第一步 不处理 跳转页面 第二步 处理 跳转页面
public class HelloController{
    @RequestMapping("/hello")
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }
}