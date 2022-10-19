package com.lzq.service;

import com.lzq.domain.Memory;
import com.lzq.domain.Word;

import java.util.List;

public interface IMemoryService {
    void add(Memory memory);

    void delete(Integer userId, Integer wordId);

    List<Word> queryForgetWords(Integer userId);

    List<Memory> query(Memory memory);

    List<Memory> queryByUserIdWordId(int userId, int wordId);
}
