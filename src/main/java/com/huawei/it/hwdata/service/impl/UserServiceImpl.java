package com.huawei.it.hwdata.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huawei.it.hwdata.dao.UserDao;
import com.huawei.it.hwdata.service.UserService;
import com.huawei.it.hwdata.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public boolean save(UserVo vo) {
		return false;
	}

	public void update(UserVo vo) {
		// TODO Auto-generated method stub
		
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	public List<UserVo> getDetail() {
 
		return userDao.getDetail();
		 
	}

	public UserVo findById(String id) {
		return userDao.findById(id);
	}
}
