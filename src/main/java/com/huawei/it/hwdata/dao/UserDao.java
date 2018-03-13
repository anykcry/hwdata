package com.huawei.it.hwdata.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.huawei.it.hwdata.vo.UserVo;

@Repository
public interface UserDao {
	
	public void save(UserVo vo);
    public void update(UserVo vo);
    public void delete(String id);
    public List<UserVo> getDetail();
}
