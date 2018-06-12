package com.huawei.it.hwdata.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.huawei.it.hwdata.dao.OrderDao;
import com.huawei.it.hwdata.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.huawei.it.hwdata.dao.UserDao;
import com.huawei.it.hwdata.service.UserService;
import com.huawei.it.hwdata.vo.UserVo;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;


	@Autowired
	private OrderDao orderDao;


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


	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void testInsert(UserVo uv, OrderVo vo) throws  RuntimeException{

			userDao.save(uv);
		int i = 1 / 0;

		orderDao.insert(vo);

	}
}
