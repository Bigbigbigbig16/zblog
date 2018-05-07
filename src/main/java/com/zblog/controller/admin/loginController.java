package com.zblog.controller.admin;

import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.Route;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;

@Path("login")
public class loginController {
    /*登录页面*/
    @Route("")
    public void login(Response response) {
        response.render("admin/login.html");
    }


    /*注册页面*/
    @Route("register")
    public String register(Request request) {
        return "register.html";
    }

}
