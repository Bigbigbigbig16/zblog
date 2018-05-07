package com.zblog.service;

import com.blade.ioc.annotation.Bean;
import com.blade.kit.DateKit;
import com.zblog.model.entity.Users;

@Bean
public class UserService {
    /*
    *保存新用户
    * 暂时未加入数据校验
    */
    public Integer saveUser(Users user){

        /*测试数据*/
        user.setUsername("xiaowang22");
        user.setPassword("xiao12345622");
        user.setScreen_name("xw11111122");
        int time = DateKit.nowUnix();
        user.setCreated(time);

        System.out.println("需要保存的用户信息：  "+user);
        Long tempcid = user.save();
        Integer cid = Integer.parseInt(String.valueOf(tempcid));
        System.out.println("需要保存的用户信息 ID ：  "+cid);
        return cid;
    }

}
