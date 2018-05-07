package com.zblog.controller.admin;

import com.blade.jdbc.page.Page;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.http.Request;
import com.zblog.model.dto.Types;
import com.zblog.model.entity.Contents;

public class ArticleController {
    /**
     * 文章管理首页
     *
     * @param page
     * @param limit
     * @param request
     * @return
     */
    @GetRoute(value = "")
    public String index(@Param(defaultValue = "1") int page, @Param(defaultValue = "15") int limit,
                        Request request) {

        Page<Contents> articles = new Contents().where("type", Types.ARTICLE).page(page, limit, "created desc");
        request.attribute("articles", articles);
        return "admin/article_list.html";
    }

    /**
     * 文章发布页面
     *
     * @param request
     * @return
     */
    @GetRoute(value = "publish")
    public String newArticle(Request request) {

        return "admin/article_edit";
    }
}
