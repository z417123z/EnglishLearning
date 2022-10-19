package com.lzq.dao;

import com.lzq.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBookDao {
    List<Book> query(Book book);
    Book queryBookById(Integer id);
    int insertBook(Book book);
    int deleteBook(Integer id);
    int updateBook(Book book);

    List<Book> queryByName(@Param("name") String name);

    List<Book> queryBookshelf(@Param("userId") Integer userId);
}

