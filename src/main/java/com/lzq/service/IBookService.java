package com.lzq.service;

import com.lzq.domain.Book;

import java.util.List;

public interface IBookService {

    public int insertBook(Book book);

    public int deleteBook(int id) throws Exception;

    public int updateBook(Book book) throws Exception;

    public Book queryBookById(int id) throws Exception;

    public List<Book> queryByPage(Book book, int pageNum, int pageSize);

    List<Book> queryByName(String name, int pageNum, int pageSize);

}
