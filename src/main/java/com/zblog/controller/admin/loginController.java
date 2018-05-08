package com.zblog.controller.admin;

import com.blade.ioc.annotation.Inject;
import com.blade.kit.DateKit;
import com.blade.kit.EncryptKit;
import com.blade.kit.StringKit;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.Route;
import com.blade.mvc.http.HttpMethod;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.blade.mvc.http.Session;
import com.blade.mvc.ui.RestResponse;
import com.zblog.exception.TipException;
import com.zblog.model.dto.LogActions;
import com.zblog.model.entity.Logs;
import com.zblog.model.entity.Users;
import com.zblog.model.param.LoginParam;
import com.zblog.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("admin")
public class loginController {
    @Inject
    private UserService userService;

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

    /*跳转到登录页面*/
    @Route(value = "login", method = HttpMethod.GET)
    public String login(Response response) {
        return "admin/login.html";
    }

    /*登录验证*/
    @Route(value = "login", method = HttpMethod.POST)
    @JSON
    public RestResponse doLogin(LoginParam loginParam, Request request,
                                Session session, Response response) {
        try {
            String pwd = EncryptKit.md5(loginParam.getUsername(), loginParam.getPassword());
            Users user = new Users().where("username", loginParam.getUsername()).and("password", pwd).find();
            if (null == user) {
                return RestResponse.fail("用户名或密码错误");
            }else {
                System.out.println("Mark 登录成功");
                new Logs(LogActions.LOGIN, loginParam.getUsername(), request.address(), user.getUid()).save();
                return RestResponse.ok();
            }
        }catch (Exception e){
            String msg = "登录失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            } else {
                log.error(msg, e);
            }
            return RestResponse.fail(msg);
        }


    }



}
