package com.zblog.controller.admin;

import com.blade.ioc.annotation.Inject;
import com.blade.kit.DateKit;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.Route;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.zblog.model.entity.Users;
import com.zblog.service.UserService;

@Path("login")
public class loginController {
    @Inject
    private UserService userService;

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

    /*保存用户信息 test*/
    @Route("saveUser")
    public String saveUserInfo(Request request){
        Users user = new Users();

        userService.saveUser(user);
        return "save.html";
    }

}
