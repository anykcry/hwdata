package com.huawei.it.hwdata.dao;

import com.huawei.it.hwdata.vo.OrderVo;

public interface OrderDao
{

    public void insert(OrderVo vo) throws RuntimeException;
}
