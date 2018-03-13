package com.huawei.it.hwdata.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	

	@RequestMapping("/add")
	public void add(){
		System.out.println("--------add----");
		
	}
	@RequestMapping("/delete")
	public void delete(){
		System.out.println("--------delete----");
		
	}
	@RequestMapping("/update")
	@ResponseBody
	public void update(){
		System.out.println("--------update----");
		
	}
	@RequestMapping("/detail")
	@ResponseBody
	public void list(){
		System.out.println("--------detail----");
		
	}

}
