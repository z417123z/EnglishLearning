package com.lzq.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzq.dao.IBookDao;
import com.lzq.dao.IBookshelfDao;
import com.lzq.domain.Book;
import com.lzq.domain.Bookshelf;
import com.lzq.service.IBookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookshelfServiceImpl implements IBookshelfService {
    @Autowired
    private IBookshelfDao bookshelfDao;
    @Autowired
    private IBookDao bookDao;

    @Override
    public void add(Bookshelf bookshelf) {
        bookshelfDao.add(bookshelf);
    }

    @Override
    public void deleteById(int userId, int bookId) {
        bookshelfDao.deleteById(userId, bookId);
    }

    @Override
    public void updateWordList(int userId, int bookId, int wordList) {
        bookshelfDao.updateWordList(userId, bookId, wordList);
    }

    @Override
    public Bookshelf queryWordList(int bookId, int userId) {
        return bookshelfDao.queryWordList(bookId, userId);
    }


    @Override
    public List<Book> queryBookshelf(Integer userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return bookDao.queryBookshelf(userId);
    }

    @Override
    public List<Bookshelf> queryAll(Bookshelf bookshelf) {
        return bookshelfDao.queryAll(bookshelf);
    }

    @Override
    public List<Bookshelf> queryBookshelfByBookIdUserId(int bookId, int userId) {
        return bookshelfDao.queryBookshelfByBookIdUserId(bookId, userId);
    }
}
