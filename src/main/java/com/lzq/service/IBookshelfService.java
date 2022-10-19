package com.lzq.service;

import com.lzq.domain.Book;
import com.lzq.domain.Bookshelf;

import java.util.List;

public interface IBookshelfService {
    /**
     * 用户添加到书架
     * @param bookshelf
     */
    void add(Bookshelf bookshelf);

    /**
     * 用户删书架的书
     * @param userId
     * @param bookId
     */
    void deleteById(int userId, int bookId);

    /**
     * 更新用户查看的单词表
     * @param userId
     * @param bookId
     * @param wordList
     */
    void updateWordList(int userId, int bookId, int wordList);

    /**
     * 查询用户看到第几个表
     * @param bookId
     * @param userId
     * @return
     */
    Bookshelf queryWordList(int bookId, int userId);

    /**
     * 显示用户看的书架
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Book> queryBookshelf(Integer userId, int pageNum, int pageSize);

    /**
     * 查书架
     * @param bookshelf
     * @return
     */
    List<Bookshelf> queryAll(Bookshelf bookshelf);

    List<Bookshelf> queryBookshelfByBookIdUserId(int bookId, int userId);
}
