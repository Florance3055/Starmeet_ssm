package com.flor.dao;

import com.flor.pojo.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {
    //添加评论
    @Insert("insert into t_comment(uid,username,comment) values (#{uid},#{username},#{comment})")
    int addComment(Comment comment);

    @Select("select * from t_comment")
    List<Comment> findAllComment();

    //删除账号DELETE FROM 表名称 WHERE 列名称 = 值
    @Delete("delete from t_comment  where id=#{id} ")
    int deleteComment(@Param("id") Integer id);

}
