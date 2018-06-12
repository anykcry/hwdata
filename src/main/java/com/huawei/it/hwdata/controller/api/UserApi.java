package com.huawei.it.hwdata.controller.api;

import com.huawei.it.hwdata.controller.BaseController;
import com.huawei.it.hwdata.service.UserService;
import com.huawei.it.hwdata.vo.UserVo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@RestController
@RequestMapping("/userapi")
public class UserApi extends BaseController{
	

	private Logger log= LogManager.getLogger(UserApi.class); 
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
	public Object add(@RequestBody UserVo ds){
		
		System.out.println("--------add----");
        UserVo vo = new UserVo();
        vo.setAddress("江东十八里");
        vo.setId(12l);
        vo.setAge(20);
        vo.setUserName("zhang san");
        vo.setStartTime(ds.getStartTime());

        
        UserVo v2=(UserVo) vo.clone();
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
		log.info("kkkkk---------------->>>>");
		System.out.println("--------update--11212--");
		return "{\"status\":\"200\",\"test\":\"中兴旺\"}";
		
	}
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List> list(){

        System.out.println("--------detail----");
		
		List<UserVo> list = userService.getDetail();

        return new ResponseEntity<List>(list,HttpStatus.OK);

//
//		String useName = "十八";
//		for(UserVo vo:list){
//			System.out.println("userName----->>"+vo.getUserName());
//			useName = vo.getUserName();
//		}


////		return "{\"userName\":\""+useName+"\"}";
//
//        UserVo vo = new UserVo();
//        vo.setAddress("江东十八里");
//        vo.setId(12l);
//        vo.setAge(20);
//        vo.setUserName("zhang san");
//
//        return vo;
		
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

    @RequestMapping(value="/getByName",method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UserVo> getEntity(@RequestParam (required = false) String userName){


        int a = (int)(Math.random()*10000);
	    UserVo vo = new UserVo();
	    vo.setId(a);
	    vo.setUserName(userName);


	    return new ResponseEntity<UserVo>(vo,HttpStatus.OK);




    }

     
    
    public static void main(String[] args){
    	
    	UserVo vo = new UserVo();
        vo.setAddress("江东十八里");
        vo.setId(12l);
        vo.setAge(20);
        vo.setUserName("zhang san");
        
        
        UserVo v2 = (UserVo)vo.clone();
        
        System.out.println(v2.getAddress());
    	
    }
}
