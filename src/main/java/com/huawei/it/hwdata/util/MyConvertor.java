package com.huawei.it.hwdata.util;

import com.huawei.it.hwdata.vo.UserVo;
import org.springframework.core.convert.converter.Converter;

public class MyConvertor implements Converter<String, UserVo> {
    public UserVo convert(String s) {

        System.out.println("==a-df=a-f=-af=d");

        return null;
    }
}
