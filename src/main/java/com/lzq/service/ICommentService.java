package com.lzq.service;

import com.lzq.domain.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICommentService {
    List<Comment> queryCommentList(Comment comment, int pageNum, int pageSize);

    List<Comment> queryAllUserCommentList(Comment comment, int pageNum, int pageSize);

    List<Comment> queryUserCommentList(Comment comment, int pageNum, int pageSize,
                                       @Param("id") int userId);


    Comment queryCommentById(int id);

    int insertComment(Comment comment);

    int updateComment(Comment comment);

    int deleteComment(int id);

    void deleteUserComment(int id);

    void showUserComment(int id);

    List<Comment> queryByUserContent(String content, int pageNum, int pageSize, int id);

    List<Comment> queryByContent(String content, int pageNum, int pageSize, Comment comment);

}
