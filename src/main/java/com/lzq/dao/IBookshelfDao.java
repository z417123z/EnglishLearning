package com.lzq.dao;

import com.lzq.domain.Bookshelf;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBookshelfDao {

    /**
     * 添加书架
     * @param bookshelf
     */
    void add(Bookshelf bookshelf);

    /**
     * 删除用户，删除对应书架
     * @param userId
     */
    void deleteByUser(Integer userId);

    /**
     * 用户从书架删书
     * @param userId
     * @param bookId
     */
    void deleteById(@Param("userId") Integer userId, @Param("bookId") Integer bookId);

    /**
     * 删书、删对应书架的书
     * @param bookId
     */
    void deleteByBookId(Integer bookId);

    /**
     * 更新用户查看的表数
     * @param userId
     * @param bookId
     * @param wordList
     */
    void updateWordList(@Param("userId") Integer userId,
                        @Param("bookId") Integer bookId,
                        @Param("wordList") Integer wordList);

    /**
     * 查书架
     * @param bookshelf
     * @return
     */
    List<Bookshelf> queryAll(Bookshelf bookshelf);

    /**
     * 查用户看到第几个表
     * @param userId
     * @param bookId
     * @return
     */
    Bookshelf queryWordList(@Param("bookId") Integer bookId,
                            @Param("userId") Integer userId);


    List<Bookshelf> queryBookshelfByBookIdUserId(@Param("bookId") int bookId,
                                                 @Param("userId") int userId);
}
