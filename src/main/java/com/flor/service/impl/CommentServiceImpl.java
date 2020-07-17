package com.flor.service.impl;

import com.flor.dao.CommentDao;
import com.flor.dao.UserDao;
import com.flor.pojo.Comment;
import com.flor.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;
    private final UserDao userDao;

    public CommentServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Map addComment(String userComment, String session) {

        Comment comment = new Comment();
        Map identity = userDao.GetIdentity(session);

        comment.setUid((Integer) identity.get("id"));
        comment.setUsername((String) identity.get("username"));
        comment.setComment(userComment);

        HashMap map = new HashMap();
        if (commentDao.addComment(comment) == 1) {
            map.put("code", "200");
            map.put("message", "用户评论成功");
        } else {
            map.put("code", "210");
            map.put("message", "用户评论失败");
        }

        return map;
    }

    @Override
    public List<Comment> findAllComment() {
        return commentDao.findAllComment();
    }

    @Override
    public Map deleteComment(Integer id) {
        HashMap map = new HashMap();

        if (commentDao.deleteComment(id) == 1) {
            map.put("code", "200");
            map.put("message", "评论删除成功");
        } else {
            map.put("code", "210");
            map.put("message", "评论删除失败");
        }

        return map;
    }
}