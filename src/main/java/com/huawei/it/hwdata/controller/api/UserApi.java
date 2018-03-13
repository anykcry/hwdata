package com.huawei.it.hwdata.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei.it.hwdata.service.UserService;
import com.huawei.it.hwdata.vo.UserVo;


@Controller
@RequestMapping("/userapi")
public class UserApi {
	

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public void add(){
		
		System.out.println("--------add----");
		
	}
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	@ResponseBody
	public void delete(){
		System.out.println("--------delete----");
		
	}
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	@ResponseBody
	public void update(){
		System.out.println("--------update--11212--");
		
	}
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	@ResponseBody
	public String list(){
		
		List<UserVo> list = userService.getDetail();
		
		String useName = "";
		for(UserVo vo:list){
			System.out.println("userName----->>"+vo.getUserName());
			useName = vo.getUserName();
		}
		
		
		
		System.out.println("--------detail----");
		return "{\"userName\":\""+useName+"\"}";
		
	}

}
