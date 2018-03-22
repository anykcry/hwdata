package com.huawei.it.hwdata;

import com.huawei.it.hwdata.dao.UserDao;
import com.huawei.it.hwdata.service.UserService;
import com.huawei.it.hwdata.util.ApiTestUtil;
import com.huawei.it.hwdata.vo.UserVo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 *  dao 层的测试，直接mock dao  层进行测试
 */
public class UserApiDAOTest {

    @Mock
    private UserDao userDao;

    private UserVo u1;
    private UserVo u2;

    @Before
    public void bef(){
        userDao = Mockito.mock(UserDao.class);
        u1=new UserVo();
        u1.setUserName("xiaosan");
        u1.setAge(20);
        u1.setId(12l);
        u1.setAddress("大家晥人");

        u2=new UserVo();
        u2.setUserName("xiaosan222");
        u2.setAge(204);
        u2.setId(123l);
        u2.setAddress("中不构晥人");

        when(userDao.getDetail()).thenReturn(Arrays.asList(u1,u2));
        when(userDao.findById("123")).thenReturn(u2);

    }

    @Test
    public void getdetail(){

        List<UserVo> list = userDao.getDetail();

        for(UserVo vo : list){

            System.out.println(vo.getAddress());
        }

    }

    @Test
    public void findById(){

        UserVo list = userDao.findById("123");
        System.out.println(list.getAddress());

    }


}
