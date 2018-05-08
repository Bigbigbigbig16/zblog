package com.zblog.service;

import com.blade.jdbc.page.Page;
import com.blade.kit.BladeKit;
import com.blade.kit.DateKit;
import com.zblog.model.dto.Comment;
import com.zblog.model.entity.Comments;
import com.zblog.model.entity.Contents;

import java.util.ArrayList;
import java.util.List;

public class CommentService {
    /**
     * 保存评论
     *
     * @param comments
     */
    public void saveComment(Comments comments){
        Contents contents = new Contents().where("cid", comments.getCid()).find();

        comments.setOwner_id(contents.getAuthorId());
        comments.setCreated(DateKit.nowUnix());
        comments.setParent(comments.getCoid());
        comments.setCoid(null);
        comments.save();

        Contents temp = new Contents();
        temp.setCommentsNum(contents.getCommentsNum() + 1);
        temp.update(contents.getCid());
    }

    /**
     * 获取文章下的评论
     *
     * @param cid
     * @param page
     * @param limit
     * @return
     */
    public Page<Comment> getComments(Integer cid, int page, int limit) {
        if (null != cid) {
            Page<Comments> cp = new Comments().where("cid", cid).and("parent", 0).page(page, limit, "coid desc");
            return cp.map(parent -> {
                Comment comment  = new Comment(parent);
                return comment;
            });
        }
        return null;
    }

    /**
     * 根据主键查询评论
     *
     * @param coid
     * @return
     */
    public Comments byId(Integer coid) {
        if (null != coid) {
            return new Comments().find(coid);

        }
        return null;
    }
}
