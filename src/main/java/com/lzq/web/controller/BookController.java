package com.lzq.web.controller;

import com.github.pagehelper.PageInfo;
import com.lzq.domain.Book;
import com.lzq.domain.User;
import com.lzq.domain.Word;
import com.lzq.service.IBookService;
import com.lzq.service.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    IWordService wordService;

    /**
     * 跳转到添加页面
     * @return
     */
    @RequestMapping(value = "toAdd")
    public String toAdd() {
        return "/book/book_add";
    }

    /**
     * 添加方法
     * @param book
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "add")
    public String add(Book book, HttpSession session) throws Exception {
        String fileName = (String) session.getAttribute("fileName");
        String path = "/resources/upload/" + fileName;
        book.setPicture(path);
        bookService.insertBook(book);
        return "redirect:/book/list";
    }

    /**
     * 跳转到更新页面
     * @param bookId
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "toUpdate")
    public ModelAndView toUpdate(@RequestParam("bookId") int bookId,
                                 HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("/book/book_update");
        Book book = bookService.queryBookById(bookId);
        mv.addObject("book", book);
        session.setAttribute("bookId", bookId);
        return mv;
    }

    /**
     * 更新书本信息方法
     * @param book
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update")
    public ModelAndView update(Book book, HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("redirect:/book/list");
        mv.addObject("book", book);
        String fileName = (String) session.getAttribute("fileName");
        String path = "/resources/upload/" + fileName;
        book.setPicture(path);
        bookService.updateBook(book);
        return mv;
    }

    /**
     * 删除书籍
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("id") int id) throws Exception {
        bookService.deleteBook(id);
        return "redirect:/book/list";
    }

    /**
     * 所以书本信息查看
     * @param page
     * @param rows
     * @param book
     * @return
     */
    @RequestMapping(value = "/list")
    public ModelAndView list(@RequestParam(required = false, defaultValue = "1") int page,
                             @RequestParam(required = false, defaultValue = "10") int rows,
                             Book book) {
        ModelAndView result = new ModelAndView("book/book_list");
        List<Book> bookList = bookService.queryByPage(book, page, rows);
        result.addObject("pageInfo", new PageInfo<Book>(bookList));
        result.addObject("queryParam", book);
        result.addObject("page", page);
        result.addObject("rows", rows);
        return result;
    }

    /**
     * 书名查询
     * @param page
     * @param rows
     * @param name
     * @param book
     * @return
     */
    @RequestMapping(value = "/queryName")
    public ModelAndView queryName(@RequestParam(required = false, defaultValue = "1") int page,
                                  @RequestParam(required = false, defaultValue = "10") int rows,
                                  @RequestParam("name") String name,
                                  Book book) {
        ModelAndView result = new ModelAndView("book/book_list");
        List<Book> bookList = bookService.queryByName(name, page, rows);
        result.addObject("pageInfo", new PageInfo<Book>(bookList));
        result.addObject("queryParam", book);
        result.addObject("page", page);
        result.addObject("rows", rows);
        return result;
    }

    /**
     * 用户的查询所有书名
     * @param page
     * @param rows
     * @param name
     * @param book
     * @return
     */
    @RequestMapping(value = "/queryNameForUser")
    public ModelAndView queryNameForUser(@RequestParam(required = false, defaultValue = "1") int page,
                                         @RequestParam(required = false, defaultValue = "10") int rows,
                                         @RequestParam("name") String name,
                                         Book book) {
        ModelAndView result = new ModelAndView("book/user_book_query");
        List<Book> bookList = bookService.queryByName(name, page, rows);
        result.addObject("pageInfo", new PageInfo<Book>(bookList));
        result.addObject("queryParam", book);
        result.addObject("page", page);
        result.addObject("rows", rows);
        result.addObject("name", name);
        return result;
    }

    /**
     * 用户的所有书籍查看页面
     * @param page
     * @param rows
     * @param book
     * @param user
     * @return
     */
    @RequestMapping(value = "/userBook")
    public ModelAndView userBook(@RequestParam(required = false, defaultValue = "1") int page,
                                 @RequestParam(required = false, defaultValue = "10") int rows,
                                 Book book, User user) {
        ModelAndView mv = new ModelAndView("book/user_book_list");
        List<Book> bookList = bookService.queryByPage(book, page, rows);
        mv.addObject("pageInfo", new PageInfo<Book>(bookList));
        mv.addObject("user", user);
        mv.addObject("queryParam", book);
        mv.addObject("page", page);
        mv.addObject("rows", rows);
        return mv;
    }

    /**
     * 书的信息
     * @param bookId
     * @param word
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toView")
    public ModelAndView toView(@RequestParam("bookId") int bookId, Word word,
                               @RequestParam(required = false, defaultValue = "1") int page,
                               @RequestParam(required = false, defaultValue = "10") int rows) throws Exception{
        Book book = bookService.queryBookById(bookId);
        ModelAndView mv = new ModelAndView("/book/book_view");
        List<Word> wordList = wordService.queryWordList(word, page, rows, bookId);
        mv.addObject("book", book);
        mv.addObject("pageInfo", new PageInfo<Word>(wordList));
        return mv;
    }
}
