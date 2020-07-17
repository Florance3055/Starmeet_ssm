package com.flor.service;

import com.flor.pojo.Comment;
import com.flor.pojo.User;

import java.util.List;
import java.util.Map;

public interface CommentService {
    Map addComment(String userComment, String session);

    List<Comment> findAllComment();

    Map deleteComment(Integer id);
}
