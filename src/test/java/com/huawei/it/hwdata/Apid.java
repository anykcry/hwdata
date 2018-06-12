package com.huawei.it.hwdata;

import org.junit.Assert;
import org.junit.Test;

public class Apid {

    @Test
    public void test_modem(){
        int a = (int)(Math.random()*10000);


        Assert.assertNotNull(a);
        System.out.println(a);
    }
}
