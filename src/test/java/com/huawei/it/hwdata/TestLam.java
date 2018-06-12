package com.huawei.it.hwdata;

import com.huawei.it.hwdata.vo.UserVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestLam {

    public static void main(String[] args){
        List<UserVo> userList = new ArrayList<>();

        UserVo u1=new UserVo();
        u1.setUserName("xiaosan");
        u1.setAge(20);
        u1.setId(12l);
        u1.setAddress("大家晥人");

        UserVo  u2=new UserVo();
        u2.setUserName("xiaosan222");
        u2.setAge(204);
        u2.setId(123l);
        u2.setAddress(null);

        userList.add(u1);
        userList.add(u2);


        try{

//             List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
//             double allCost = cost.stream().map(x -> x*0.05).reduce((sum,x) -> sum + x).get();


            String kk = userList.stream().map(x->x.getAddress()+"-").reduce((sum,x)->sum+x).get();


            System.out.println("-666--->>>"+kk);


            List<UserVo> aa =  userList.stream().filter(x->x.getAge()==20).collect(Collectors.toList());


//            UserVo dd = userList.stream().filter(x->x.getId()==1231);

          //  System.out.println("----------->>>>"+dd.getAddress());


           // System.out.println(aa.size());


       //     userList.stream().filter(x->x.getId())

        }catch (Exception e)
        {
            e.printStackTrace();


        }


    }
}
