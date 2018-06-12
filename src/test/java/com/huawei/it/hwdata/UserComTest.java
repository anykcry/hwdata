package com.huawei.it.hwdata;

import com.huawei.it.hwdata.service.UserService;
import com.huawei.it.hwdata.util.ApiTestUtil;
import com.huawei.it.hwdata.vo.OrderVo;
import com.huawei.it.hwdata.vo.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *  集成测试，测试service 层，拉通dao层
 */
public class UserComTest extends ApiTestUtil{

    @Autowired
    private UserService userService;

    @Test
    public void test_service (){
        List<UserVo> list = userService.getDetail();

        for(UserVo vo:list){

            System.out.println(vo.getAddress());

        }


    }



    @Test
    public void test_tan() throws  Exception{

        OrderVo vo = new OrderVo();
        vo.setOrderName("ttt");
        vo.setOrderPrice("2111");
        vo.setUserId("12");

        UserVo uv = new UserVo();
        uv.setUserName("xiaoming");
        uv.setAge(23);
        uv.setAddress("北京大学");

        userService.testInsert(uv,vo);


    }
}
