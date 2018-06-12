package com.huawei.it.hwdata.util;


import com.huawei.it.hwdata.controller.api.UserApi;
import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import  org.mockito.InjectMocks;
import java.nio.charset.Charset;

//API测试必须要得到 WebApplicationContext
@WebAppConfiguration(value = "src/main/webapp")
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {DhbWebApplicationInitializer.class})
//指定bean注入的配置文件
@ContextConfiguration(locations = {"classpath*:config/spring/applicationContext.xml","classpath*:config/spring/spring-mvc.xml"})
public class ApiTestUtil extends AbstractJUnit4SpringContextTests {


    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private WebApplicationContext wac;

    protected MockMvc mockMvc;

    @InjectMocks
    private UserApi userApi;

    @Before
    public void setup() throws Exception {

    	//使用given方式（测试远程代码）
        RestAssured.baseURI= "http://127.0.0.1";
        RestAssured.port = 8080;
        RestAssured.basePath = "/hwdata";
        //不使用given方式
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

    }

    //鉴权方法
    //获取token


}
