package com.lzq.dao;

import com.lzq.domain.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICommentDao {
    List<Comment> query(Comment comment);

    List<Comment> queryAllUserComment(Comment comment);

    List<Comment> queryUserComment(Comment comment, @Param("id") Integer id);

    List<Comment> queryByUserContent(@Param("content") String content, @Param("id") Integer id);

    List<Comment> queryByContent(@Param("content") String content, Comment comment);

    Comment queryCommentById(@Param("id") Integer id);

    int insertComment(Comment comment);

    int updateComment(Comment comment);

    int deleteComment(@Param("id") Integer id);

    void deleteUserComment(@Param("id") Integer id);

    void showUserComment(@Param("id") Integer id);

    void deleteByUserId(@Param("id") int id);


}
