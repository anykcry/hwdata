package com.huawei.it.hwdata.service;

import java.util.List;

import com.huawei.it.hwdata.vo.UserVo;

public interface UserService {
	
	public boolean save(UserVo vo);
    public void update(UserVo vo);
    public void delete(String id);
    public List<UserVo> getDetail();
    public UserVo findById(String id);

}
