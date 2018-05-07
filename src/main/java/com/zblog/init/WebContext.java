package com.zblog.init;

import com.blade.Blade;
import com.blade.event.BeanProcessor;
import com.blade.ioc.annotation.Bean;
import com.blade.jdbc.Base;
import org.sql2o.Sql2o;

/**
 * Tale初始化进程
 */
@Bean
public class WebContext implements BeanProcessor {


    @Override
    public void processor(Blade blade) {

    }

    @Override
    public void preHandle(Blade blade) {

        String url = "jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=utf-8&useSSL=false",user = "root",pass = "root";
        Sql2o sql2o = new Sql2o(url,user,pass);
        Base.open(sql2o);
        System.out.println("Mark 开启数据库连接池");
    }
}
