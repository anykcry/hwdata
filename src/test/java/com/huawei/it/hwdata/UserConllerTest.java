package com.huawei.it.hwdata;

import com.huawei.it.hwdata.controller.web.UserController;
import com.huawei.it.hwdata.util.ApiTestUtil;
import com.huawei.it.hwdata.vo.UserVo;
import com.sun.tools.internal.ws.processor.model.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class UserConllerTest extends ApiTestUtil {



    @Test
    public void test_con(){
        try {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/user/detail"))
   .andExpect(view().name("/WEB-INF/jsp/detail.jsp"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test_con2(){
        try {
            MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/user/detail"))
                    .andExpect(MockMvcResultMatchers.model().attribute("userName","AAAA"))
                    .andReturn();
            //UserVo vo = (UserVo)result.getRequest().getAttribute("vo");
            //Assert.assertEquals("AAAA",vo.getUserName());

            //Assert.assertEquals("/WEB-INF/jsp/detail.jsp",result.getModelAndView().getViewName());
//                    .andExpect(view().name("/WEB-INF/jsp/detail.jsp"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
