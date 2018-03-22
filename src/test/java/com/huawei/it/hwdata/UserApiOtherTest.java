package com.huawei.it.hwdata;

import com.huawei.it.hwdata.dao.UserDao;
import com.huawei.it.hwdata.service.UserService;
import com.huawei.it.hwdata.util.ApiTestUtil;
import com.huawei.it.hwdata.vo.UserVo;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * service 层测试， 先mock dao层，再把dao射映到serivce
 */
public class UserApiOtherTest extends ApiTestUtil {

    @Mock
    private UserDao userDao;

    @Autowired
    private UserService userService;

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
        u2.setAddress("中为晥人");

        when(userDao.getDetail()).thenReturn(Arrays.asList(u1,u2));
        when(userDao.findById("123")).thenReturn(u2);

//        when(mockedBookDAL.getBook("8131721019")).thenReturn(book1);
//        when(mockedBookDAuserDaoL.addBook(book1)).thenReturn(book1.getIsbn());
//
//        when(mockedBookDAL.updateBook(book1)).thenReturn(book1.getIsbn());
        ReflectionTestUtils.setField(userService, "userDao", userDao);



    }

    @Test
    public void getdetail(){

        List<UserVo> list = userService.getDetail();

        for(UserVo vo : list){

            System.out.println(vo.getAddress());
        }

    }

    @Test
    public void findById(){

         UserVo  list = userService.findById("123");
         System.out.println(list.getAddress());

    }

}
