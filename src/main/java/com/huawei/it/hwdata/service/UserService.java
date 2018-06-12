package com.huawei.it.hwdata.service;

import java.util.List;

import com.huawei.it.hwdata.vo.OrderVo;
import com.huawei.it.hwdata.vo.UserVo;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface UserService {

    public boolean save(UserVo vo);

    public void update(UserVo vo);

    public void delete(String id);

    public List<UserVo> getDetail();

    public UserVo findById(String id);

//    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)


    public void testInsert(UserVo uv, OrderVo vo) throws Exception;

}


