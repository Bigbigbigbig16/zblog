package com.zblog.controller.admin;

import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.Route;
import com.blade.mvc.http.HttpMethod;
import com.blade.mvc.http.Request;

@Path("admin")
public class IndexController {
    /**
     * 仪表盘
     */
    @Route(value = {"/", "index"}, method = HttpMethod.GET)
    public String index(Request request) {
        return "admin/index.html";
    }


}
