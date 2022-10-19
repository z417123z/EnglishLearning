package com.lzq.dao;

import com.lzq.domain.BookWord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBookWordDao {

    void add(BookWord bookWord);

    List<BookWord> query(BookWord bookWord);

    void deleteByBookId(@Param("bookId") Integer bookId);

    int insertWordToBook(List<BookWord> bookWordList);

    List<BookWord> queryByBookId(@Param("bookId") Integer bookId);


    List<BookWord> queryMidByBookIdWordId(@Param("bookId") int bookId,
                                          @Param("wordId") int wordId);

    void deleteWordFromBook(@Param("bookId") int bookId,
                            @Param("wordId") int wordId);
}
