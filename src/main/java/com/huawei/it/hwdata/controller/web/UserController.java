package com.huawei.it.hwdata.controller.web;

import com.huawei.it.hwdata.service.UserService;
import com.huawei.it.hwdata.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
	

	@Autowired
	private UserService userService;

	@RequestMapping("/add")
	public void add(){
		System.out.println("--------add----");

		
	}
	@RequestMapping("/delete")
	public void delete(){
		System.out.println("--------delete----");
		
	}
	@RequestMapping("/update")
	public void update(){
		System.out.println("--------update----");
		
	}
	@RequestMapping("/detail")
	public ModelAndView list(){
		System.out.println("--------detail----");

		ModelAndView mv=new ModelAndView();
		List<UserVo> list = userService.getDetail();

		String useName = "十八";
		UserVo vo =list.get(0);

		mv.addObject("user",vo);
		mv.addObject("userName",vo.getUserName());
		mv.setViewName("/WEB-INF/jsp/detail.jsp");
		return mv;

		
	}



}
