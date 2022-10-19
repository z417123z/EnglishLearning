package com.lzq.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzq.dao.IBookDao;
import com.lzq.dao.IBookWordDao;
import com.lzq.dao.IBookshelfDao;
import com.lzq.domain.Book;
import com.lzq.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookDao bookDao;
    @Autowired
    private IBookWordDao bookWordDao;
    @Autowired
    private IBookshelfDao bookshelfDao;

    @Override
    public int insertBook(Book book){
        return bookDao.insertBook(book);
    }

    @Override
    public int deleteBook(int id) throws Exception {
        bookshelfDao.deleteByBookId(id);
        bookWordDao.deleteByBookId(id);
        return bookDao.deleteBook(id);
    }

    @Override
    public int updateBook(Book book) throws Exception {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(int id) throws Exception {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryByPage(Book book,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Book> list = bookDao.query(book);
        return list;
    }

    @Override
    public List<Book> queryByName(String name, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        name = '%' + name + '%';
        return bookDao.queryByName(name);
    }

}
