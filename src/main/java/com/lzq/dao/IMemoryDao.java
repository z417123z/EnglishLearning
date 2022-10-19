package com.lzq.dao;

import com.lzq.domain.Memory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IMemoryDao {
    /**
     * 添加到我的单词
     * @param memory
     */
    void add(Memory memory);

    /**
     * 删用户、删我的单词
     * @param userId
     */
    void deleteByUserId(@Param("userId") Integer userId);

    void deleteByWord(@Param("wordId") Integer wordId);

    /**
     * 用户删我的单词
     * @param userId
     * @param wordId
     */
    void delete(@Param("userId") Integer userId,
                @Param("wordId") Integer wordId);

    /**
     * 查我的单词
     * @param memory
     * @return
     */
    List<Memory> query(Memory memory);

    /**
     * 用户id和单词id 查表
     * @param userId
     * @param wordId
     * @return
     */
    List<Memory> queryByUserIdWordId(@Param("userId") Integer userId,
                                     @Param("wordId") Integer wordId);
}
