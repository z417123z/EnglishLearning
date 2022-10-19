package com.lzq.web.controller;

import com.github.pagehelper.PageInfo;
import com.lzq.domain.Book;
import com.lzq.domain.Bookshelf;
import com.lzq.service.IBookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/bookshelf")
public class BookshelfController {
    @Autowired
    IBookshelfService bookshelfService;

    /**
     * 书架列表
     * @param session
     * @param book
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(HttpSession session, Book book,
                             @RequestParam(required = false, defaultValue = "1") int page,
                             @RequestParam(required = false, defaultValue = "10") int rows) {
        ModelAndView mv = new ModelAndView("/bookshelf/bookshelf_list");
        int userId = (Integer) session.getAttribute("userId");
        List<Book> bookshelfList = bookshelfService.queryBookshelf(userId, page, rows);
        mv.addObject("pageInfo", new PageInfo<Book>(bookshelfList));
        mv.addObject("queryParam", book);
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        return mv;
    }

    /**
     * 从书架中删除书
     * @param bookId
     * @param session
     * @return
     */
    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam("bookId") int bookId, HttpSession session) {
        ModelAndView mv = new ModelAndView("redirect:/bookshelf/list");
        int userId = (Integer) session.getAttribute("userId");
        bookshelfService.deleteById(userId, bookId);
        return mv;
    }

    /**
     * 把书添加到书架
     * @param bookId
     * @param session
     * @param bookshelf
     * @return
     */
    @RequestMapping("/add")
    public String add(@RequestParam("bookId") int bookId, HttpSession session, Bookshelf bookshelf) {
        String msg = "true";
        int userId = (Integer) session.getAttribute("userId");
        bookshelf.setBookId(bookId);
        bookshelf.setUserId(userId);
        List<Bookshelf> bookshelfList = bookshelfService.queryBookshelfByBookIdUserId(bookId, userId);
        if (null != bookshelfList && !bookshelfList.isEmpty()) {
            msg = "error";
        } else {
            bookshelfService.add(bookshelf);
        }
        return msg;

    }



}
