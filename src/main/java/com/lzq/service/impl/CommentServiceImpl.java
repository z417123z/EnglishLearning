package com.lzq.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzq.dao.ICommentDao;
import com.lzq.domain.Comment;
import com.lzq.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ICommentService")
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private ICommentDao commentDao;
    @Override
    public List<Comment> queryCommentList(Comment comment, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return commentDao.query(comment);
    }

    @Override
    public List<Comment> queryAllUserCommentList(Comment comment, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return commentDao.queryAllUserComment(comment);
    }

    @Override
    public List<Comment> queryUserCommentList(Comment comment, int pageNum, int pageSize, int userId) {
        PageHelper.startPage(pageNum, pageSize);
        return commentDao.queryUserComment(comment, userId);
    }


    @Override
    public int insertComment(Comment comment) {
        return commentDao.insertComment(comment);
    }

    @Override
    public int deleteComment(int id)  {
        return commentDao.deleteComment(id);
    }

    @Override
    public void deleteUserComment(int id) {
        commentDao.deleteUserComment(id);
    }

    @Override
    public void showUserComment(int id) {
        commentDao.showUserComment(id);
    }

    @Override
    public List<Comment> queryByUserContent(String content, int pageNum, int pageSize, int id) {
        PageHelper.startPage(pageNum, pageSize);
        content = '%' + content + '%';
        return commentDao.queryByUserContent(content,id);
    }


    @Override
    public List<Comment> queryByContent(String content, int pageNum, int pageSize, Comment comment) {
        PageHelper.startPage(pageNum, pageSize);
        content = '%' + content + '%';
        return commentDao.queryByContent(content, comment);
    }

    @Override
    public int updateComment(Comment comment)  {
        return commentDao.updateComment(comment);
    }

    @Override
    public Comment queryCommentById(int id) {
        return commentDao.queryCommentById(id);
    }
}
