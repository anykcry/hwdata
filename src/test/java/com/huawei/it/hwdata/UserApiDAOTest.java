package com.huawei.it.hwdata;

import com.huawei.it.hwdata.dao.UserDao;
import com.huawei.it.hwdata.service.UserService;
import com.huawei.it.hwdata.util.ApiTestUtil;
import com.huawei.it.hwdata.vo.UserVo;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.stubVoid;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *  dao 层的测试，直接mock dao  层进行测试
 */
public class UserApiDAOTest {

    @Mock
    private UserDao userDao;

    private UserVo u1;
    private UserVo u2;

    private List<UserVo> userList;

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

        userList = new ArrayList<>();
        userList.add(u1);
        userList.add(u2);


        when(userDao.getDetail()).thenReturn(Arrays.asList(u1,u2));
        when(userDao.findById("123")).thenReturn(u2);






    }

    @Test
    public void testlam() throws  Exception{



        try{

           // List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
           // double allCost = cost.stream().map(x -> x+x*0.05).reduce((sum,x) -> sum + x).get();


           String kk = userList.stream().map(x->x.getAddress()+"").reduce((sum,x)->sum+x).get();


           System.out.println("---->>>"+kk);
        }catch (Exception e)
        {

        }

    }

    @Test
    public void getdetail(){

        List<UserVo> list = userDao.getDetail();
        for(UserVo vo : list){

            System.out.println(vo.getAddress());
        }
        verify(userDao).getDetail();

    }

    @Test
    public void findById(){

        UserVo list = userDao.findById("123");
        verify(userDao).findById(anyString());
        System.out.println(list.getAddress());

    }


}
