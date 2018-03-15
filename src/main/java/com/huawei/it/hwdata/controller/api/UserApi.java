package com.huawei.it.hwdata.controller.api;

import com.huawei.it.hwdata.service.UserService;
import com.huawei.it.hwdata.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequestMapping("/userapi")
public class UserApi {
	

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Object add(){
		
		System.out.println("--------add----");
        UserVo vo = new UserVo();
        vo.setAddress("江东十八里");
        vo.setId(12l);
        vo.setAge(20);
        vo.setUserName("zhang san");

        return vo;
		
	}
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	@ResponseBody
	public void delete(){
		System.out.println("--------delete----");
		
	}
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	@ResponseBody
	public String update(){
		System.out.println("--------update--11212--");
		return "{\"status\":\"200\",\"test\":\"中兴旺\"}";
		
	}
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	@ResponseBody
	public Object list(){
		
		List<UserVo> list = userService.getDetail();
//
//		String useName = "十八";
//		for(UserVo vo:list){
//			System.out.println("userName----->>"+vo.getUserName());
//			useName = vo.getUserName();
//		}

		System.out.println("--------detail----");
//		return "{\"userName\":\""+useName+"\"}";

        UserVo vo = new UserVo();
        vo.setAddress("江东十八里");
        vo.setId(12l);
        vo.setAge(20);
        vo.setUserName("zhang san");

        return vo;
		
	}

    @RequestMapping(value="/findId",method=RequestMethod.GET)
    @ResponseBody
    public Object findById(String id){

	    UserVo vo = new UserVo();
	    vo.setAddress("江东十八里");
	    vo.setId(12l);
	    vo.setAge(20);
	    vo.setUserName("zhang san");

	    return vo;



    }

    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    @ResponseBody
    public   Object delData(@PathVariable String id, HttpServletRequest request){

	    String auth = request.getHeader("auth");

	    if(auth==null) auth="";
	    if(auth.equals("")){
            return "{\"status\":\"203\",\"test\":\"缺少权限\"}";
        }else if(!auth.equals("token")){

	        return  "{\"status\":\"403\",\"test\":\"权限不对\"}";

        }

        String address=request.getParameter("address");
	    if(address==null){
            return "{\"status\":\"403\",\"test\":\"缺少必要参数\"}";
        }

        UserVo vo = new UserVo();
        vo.setAddress("江东十八里");
        vo.setId(12l);
        vo.setAge(20);
        vo.setUserName("zhang san");

        return vo;

    }

}
