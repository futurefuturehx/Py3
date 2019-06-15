package com.cloudfoundry.demo.Controlller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cloudfoundry.demo.bean.User;



@Controller
public class UserController {
	 private CrudRepository<User, String> repository;
	 @Autowired
	    public UserController(CrudRepository<User, String> repository) {
	        this.repository = repository;
	    }

	@RequestMapping("/login")
	public String login() {
		return "relogin";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

//	@RequestMapping("/saveSuccess")
//	public ModelAndView save(String username, String password) {
//		ModelAndView mav = new ModelAndView();
//		User u = userService.getByUsername(username);
//		String msg=null;
//		if(u!=null) {
//			mav.setViewName("register");
//			msg="用户已存在";
//			mav.addObject("msg",msg);
//			return mav;
//		}
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(password);
//		userService.save(user);
//		mav.setViewName("login");
//		return mav;
//	}

	@RequestMapping("/modify")
	public String modify(Map<String, Object> map) {
		return "modify";
	}

//	@RequestMapping("/modifySuccess")
//	public ModelAndView modifySuccess(String username, String OriginalPassword, String password) {
//		ModelAndView mav = new ModelAndView();
//		User user = userService.getByUsername(username);
//		String msg = null;
//		if (user == null) {
//			msg = "用户不存在";
//		} else {
//			String password1 = user.getPassword();
//			if (!password1.equals(OriginalPassword)) {
//				msg = "用户密码错误";
//			} else {
//				user.setPassword(password);
//				userService.modify(user);
//				mav.setViewName("login");
//				return mav;
//			}
//		}
//		mav.setViewName("modify");
//		mav.addObject("msg", msg);
//		return mav;
//	}

	@RequestMapping("/loginCheck1")
	public String show(Map<String, Object> map) {
		Random rd = new Random();
		int CPU_Usage = rd.nextInt(100);
		int Memory_Usage = rd.nextInt(100);
		int Network_Speed = rd.nextInt(100);
		map.put("CPU_Usage", CPU_Usage);
		map.put("Memory_Usage", Memory_Usage);
		map.put("Network_Speed", Network_Speed);
		return "show";
	}

	@RequestMapping("/loginCheck")
	public ModelAndView updates(String username, String password) {
		String msg = null;
		ModelAndView mav = new ModelAndView();
		System.out.println("0000");
		Iterable<User> users = repository.findAll();
		System.out.println("00000000000");
		int falg=1;
		for (User user : users) {
			if(user.getUsername().equals(username)&&user.getPassword().equals(password)) {
				Map<String, Integer> map = new HashMap<>();
				Random rd = new Random();
				int CPU_Usage = rd.nextInt(100);
				int Memory_Usage = rd.nextInt(100);
				int Network_Speed = rd.nextInt(100);
				map.put("CPU_Usage", CPU_Usage);
				map.put("Memory_Usage", Memory_Usage);
				map.put("Network_Speed", Network_Speed);
				mav.addObject("map", map);
				mav.setViewName("show");
				System.out.println("111");
				return mav;
			}
			if(user.getUsername().equals(username)&&!user.getPassword().equals(password)) {
				msg = "密码错误";
				falg=0;
				System.out.println("222");
			}
		}
		
		if (falg == 1) {
			msg = "用户不存在";
			System.out.println("ss");
		} 
		mav.addObject("msg", msg);
		mav.setViewName("relogin");
		return mav;
	}
	 @RequestMapping("/test")
	    public String test(){ 
	        return "index";
	    }

}
