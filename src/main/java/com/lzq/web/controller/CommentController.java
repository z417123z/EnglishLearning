package com.lzq.web.controller;

import com.github.pagehelper.PageInfo;
import com.lzq.domain.Comment;
import com.lzq.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    ICommentService commentService;

    /**
     * 评论总表
     * @param page
     * @param rows
     * @param comment
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(required = false, defaultValue = "1") int page,
                             @RequestParam(required = false, defaultValue = "10") int rows,
                             Comment comment) {
        ModelAndView mv = new ModelAndView("comment/comment_list");
        List<Comment> commentList = commentService.queryCommentList(comment, page, rows);
        mv.addObject("pageInfo", new PageInfo<>(commentList));
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        mv.addObject("queryParam", comment);
        return mv;
    }


    /**
     * 用户能看到的所有表
     * @param page
     * @param rows
     * @param comment
     * @return
     */
    @RequestMapping("/allUserList")
    public ModelAndView allUserList(@RequestParam(required = false, defaultValue = "1") int page,
                                    @RequestParam(required = false, defaultValue = "10") int rows,
                                    Comment comment) {
        ModelAndView mv = new ModelAndView("comment/comment_all_userList");
        List<Comment> commentList = commentService.queryAllUserCommentList(comment, page, rows);
        mv.addObject("pageInfo", new PageInfo<>(commentList));
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        mv.addObject("queryParam", comment);
        return mv;
    }

    /**
     * 内容查询
     * @param content
     * @param page
     * @param rows
     * @param comment
     * @return
     */
    @RequestMapping("/toQueryContentList")
    public ModelAndView toQueryContentList(@RequestParam("content") String content,
                                           @RequestParam(required = false, defaultValue = "1") int page,
                                           @RequestParam(required = false, defaultValue = "10") int rows,
                                           Comment comment) {
        ModelAndView mv = new ModelAndView("/comment/comment_query");
        List<Comment> commentList = commentService.queryByContent(content, page, rows, comment);
        mv.addObject("pageInfo", new PageInfo<>(commentList));
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        mv.addObject("queryParam", comment);
        mv.addObject("content", content);
        return mv;
    }

    /**
     * 用户查看评价表
     * @param userId
     * @param page
     * @param rows
     * @param comment
     * @return
     */
    @RequestMapping("/userList")
    public ModelAndView userList(@RequestParam("id") int userId,
                                 @RequestParam(required = false, defaultValue = "1") int page,
                                 @RequestParam(required = false, defaultValue = "10") int rows,
                                 Comment comment) {
        ModelAndView mv = new ModelAndView("/comment/comment_user_list");
        List<Comment> commentList = commentService.queryUserCommentList(comment, page, rows, userId);
        mv.addObject("pageInfo", new PageInfo<>(commentList));
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        mv.addObject("queryParam", comment);
        mv.addObject("userId", userId);
        return mv;
    }

    /**
     * 评论内容查询
     * @param userId
     * @param content
     * @param page
     * @param rows
     * @param comment
     * @return
     */
    @RequestMapping("/toQueryContentUser")
    public ModelAndView toQueryContent(@RequestParam("id") int userId,
                                       @RequestParam("content") String content,
                                       @RequestParam(required = false, defaultValue = "1") int page,
                                       @RequestParam(required = false, defaultValue = "10") int rows,
                                       Comment comment) {
        ModelAndView mv = new ModelAndView("/comment/comment_user_query");
        List<Comment> commentList = commentService.queryByUserContent(content, page, rows, userId);
        mv.addObject("pageInfo", new PageInfo<>(commentList));
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        mv.addObject("queryParam", comment);
        mv.addObject("content", content);
        mv.addObject("userId", userId);
        return mv;
    }

    /**
     * 评论详情1
     * @param commentId
     * @param comment
     * @return
     */
    @RequestMapping("/toView")
    public ModelAndView viewContent(@RequestParam("id") int commentId, Comment comment) {
        ModelAndView mv = new ModelAndView("/comment/comment_view");
        comment = commentService.queryCommentById(commentId);
        mv.addObject("comment", comment);
        return mv;
    }

    /**
     * 隐藏评论内容
     * @param commentId
     * @return
     */
    @RequestMapping("/hideContent")
    public ModelAndView hideContent(@RequestParam("id") int commentId) {
        commentService.deleteUserComment(commentId);
        return new ModelAndView("redirect:/comment/list");
    }

    @RequestMapping("/userHideContent")
    public ModelAndView userHideContent(@RequestParam("id") int commentId) {
        commentService.deleteUserComment(commentId);
        return new ModelAndView("redirect:/comment/userList?id=" + commentId);
    }

    /**
     * 展示评论内容
     * @param commentId
     * @return
     */
    @RequestMapping("/showContent")
    public ModelAndView showContent(@RequestParam("id") int commentId) {
        commentService.showUserComment(commentId);
        return new ModelAndView("redirect:/comment/list");
    }

    /**
     * 跳转到更新页面
     * @param commentId
     * @return
     */
    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(@RequestParam("id") int commentId) {
        Comment comment = commentService.queryCommentById(commentId);
        ModelAndView mv = new ModelAndView("/comment/comment_update");
        mv.addObject("comment", comment);
        return mv;
    }

    /**
     * 更新评论信息
     * @param comment
     * @return
     */
    @RequestMapping("/update")
    public ModelAndView update(Comment comment) {
        ModelAndView mv = new ModelAndView("redirect:/comment/list");
        commentService.updateComment(comment);
        return mv;
    }

    /**
     * 永久删除评论
     * @param commentId
     * @return
     */
    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam("id") int commentId) {
        ModelAndView mv = new ModelAndView("redirect:/comment/list");
        commentService.deleteComment(commentId);
        return mv;
    }

    /**
     * 添加评论
     * @param session
     * @param userId
     * @param username
     * @param name
     * @param comment
     * @return
     */
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(HttpSession session, @RequestParam("userId") int userId,
                              @RequestParam("username") String username,
                              @RequestParam("name") String name,
                              Comment comment){
        ModelAndView mv = new ModelAndView("/comment/comment_add");
        int adminId = (Integer)session.getAttribute("userId");
        mv.addObject("adminId", adminId);
        mv.addObject("userId", userId);
        mv.addObject("username", username);
        mv.addObject("name", name);
        return mv;
    }

    /**
     * 添加方法
     * @param session
     * @param comment
     * @param userId
     * @return
     */
    @RequestMapping("/add")
    public ModelAndView add(HttpSession session,  Comment comment,
                            @RequestParam("userId") int userId){
        ModelAndView mv = new ModelAndView("redirect:/user/list");
        int adminId = (Integer)session.getAttribute("userId");
        mv.addObject("adminId", adminId);
        comment.setAdminId(adminId);
        comment.setUserId(userId);
        commentService.insertComment(comment);
        return mv;
    }
}
