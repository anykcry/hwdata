package com.huawei.it.hwdata.util;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

public class GlobalDataBinder implements WebBindingInitializer {

    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {

        System.out.println("131313131----");

    }
}
