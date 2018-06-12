package com.huawei.it.hwdata.util;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class MyExceptionHandler implements HandlerExceptionResolver {


    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {

        //Result result = new Result();

        String kk ="";
        // 返回错误信息不为空
        if (ex instanceof TypeMismatchException && null != ex.getMessage()) {
            //result.setResult(ex.getMessage());
            kk="{\"aaa\":\"1111\"}";
        } else {
            kk="{\"aaa\":\"503\"}";
            //result.setResult("500 服务器异常！");
        }

        response.setHeader("content-type", "application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            Writer writer = response.getWriter();
            writer.write(kk);
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }
}
