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
        user.setUsername("xiaowang");
        user.setPassword("xiao123456");
        user.setScreen_name("xw111111");
        int time = DateKit.nowUnix();
        user.setCreated(time);

        Long tempcid = user.save();
        Integer cid = Integer.parseInt(String.valueOf(tempcid));
        return cid;
    }

}
