package com.huawei.it.hwdata;

import com.alibaba.fastjson.JSON;
import com.huawei.it.hwdata.controller.api.UserApi;
import com.huawei.it.hwdata.controller.web.UserController;
import com.huawei.it.hwdata.util.ApiTestUtil;
import com.jayway.restassured.http.ContentType;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * restFul 风格的api 测试
 *
 */
public class UserApiTest extends ApiTestUtil {
    @InjectMocks
    private UserApi userApi;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userApi).build();
    }

    @Test
    public void test_update() {

//        perform：执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
//        andExpect：添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确；
//        andDo：添加ResultHandler结果处理器，比如调试时打印结果到控制台；
//        andReturn：最后返回相应的MvcResult；然后进行自定义验证/进行下一步的异步处理
		try {

			String requestJson = "{\"id\":\"001\"}";
			String responseString = mockMvc.perform(put("/userapi/update")
									.contentType(MediaType.APPLICATION_JSON)
									.content(requestJson)).andExpect(status().isOk())
									.andReturn().getResponse().getContentAsString();

			System.out.println("--------返回的json = " + responseString);
			Map map = JSON.parseObject(responseString, Map.class);
			Assert.assertEquals("200", map.get("status"));

		} catch (Exception ex) {

		}

    }

    @Test
    public void test_find() throws Exception {
    	
        String responseString = mockMvc.perform(get("/userapi/findId")
                        .contentType(MediaType.APPLICATION_JSON).param("id", "1")
                        .header("auth", "adwer"))
		                .andExpect(status().isOk())
		                .andReturn()
		                .getResponse()
		                .getContentAsString();

        Map map = JSON.parseObject(responseString, Map.class);
        System.out.println("--------返回的json = " + responseString);
        Assert.assertEquals(20, map.get("age"));

    }


    @Test
    public void test_get() throws Exception {

        String responseString = mockMvc.perform(get("/userapi/detail")
                        .contentType(MediaType.APPLICATION_JSON).param("id", "1")
                        .header("auth", "adwer"))
		                .andExpect(status().isOk())
		                .andReturn()
		                .getResponse()
		                .getContentAsString();
        System.out.println("--------返回的json = " + responseString);
        Map map = JSON.parseObject(responseString, Map.class);
        Assert.assertEquals("zhang san", map.get("userName"));
        Assert.assertEquals("江东十八里", map.get("address"));

    }


    @Test
    public void test_add() throws Exception {

        String requestJson = "{\"id\":\"001\"}";
        String responseString = mockMvc.perform(MockMvcRequestBuilders.post("/userapi/add")
			                .contentType(MediaType.APPLICATION_JSON).param("id", "1")
			                .header("auth", "adwer")
			                .content(requestJson))
			                .andExpect(status().isOk())
			                .andReturn()
			                .getResponse()
			                .getContentAsString();


        Map map = JSON.parseObject(responseString, Map.class);
        Assert.assertEquals("zhang san", map.get("userName"));
        Assert.assertEquals("江东十八里", map.get("address"));


    }


    @Test
    public void test_delete() throws Exception {


        String responseString = mockMvc.perform(MockMvcRequestBuilders.delete("/userapi/delete/1")
                        .contentType(MediaType.APPLICATION_JSON).param("address", "newyor")
                        .header("auth", "tokenss"))
		                .andExpect(status().isOk())
		                .andReturn()
		                .getResponse()
		                .getContentAsString();
        System.out.println("--------返回的json = " + responseString);
        Map map = JSON.parseObject(responseString,Map.class);
        Assert.assertEquals("403",map.get("status"));

    }


    @Ignore
    public void test_shoud_202_detail() {

        String clientJson = "{\"name\":\"Client1\",\"clientId\":1000,\"fromEmailAddress\":\"goutham@atreya.in\"}";

        given()

                //.body(clientJson)
                .contentType(ContentType.JSON)
                .when()
                .get("/userapi/findId")
                .then()
                .statusCode(404)
                .extract().response().print();

//        System.out.println(clientCreationResponse.asString());
//        Integer clientResponseCode = clientCreationResponse.path("responseCode");
//        String clientResponseMessage = clientCreationResponse.path("responseMessage");
//        System.out.println("INT:" + clientResponseCode);
//        Assert.assertEquals(clientResponseCode, 211);
//        Assert.assertEquals(clientResponseMessage,"Client Creation Successful");

    }


}
