package com.huawei.it.hwdata;

import com.huawei.it.hwdata.controller.web.UserController;
import com.huawei.it.hwdata.util.ApiTestUtil;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class UserConllerTest extends ApiTestUtil {


    @InjectMocks
    private UserController userController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }
}
