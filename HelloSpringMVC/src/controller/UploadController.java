package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UploadController {
    //先有控制器 后有视图
    @RequestMapping("/test2")
    public ModelAndView upload() {
        return new ModelAndView("upload");
    }
    //刚开始的扫描已经知道所有控制器位置和名字了 表单交由的也是控制器
    @RequestMapping("/upload")
    //获取前台变量 以MultipartFile类型的格式传入后端
    public void upload(@RequestParam("picture") MultipartFile picture) throws Exception {
        //如果上传成功 就在控制台输出提示
        //以什么类型传入 就有什么类型的属性方法
        System.out.println(picture.getOriginalFilename()+"上传成功");
    }

}