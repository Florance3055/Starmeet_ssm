package com.flor.controller;

import com.flor.pojo.Comment;
import com.flor.service.CommentService;
import com.flor.unit.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController /* @Controller + @ResponseBody*/
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public Map addComment(String userComment, @RequestHeader("session") String session) {
        return commentService.addComment(userComment, session);
    }

    @GetMapping("/findAll")
    public JsonResult findAll() {
        List<Comment> list = commentService.findAllComment();

        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(200);
        jsonResult.setMsg("获取成功");
        jsonResult.add("data", list);
        return jsonResult;
    }

    @PostMapping("/delete")
    public Map deleteComment( Integer id) {
        return commentService.deleteComment(id);
    }
}
