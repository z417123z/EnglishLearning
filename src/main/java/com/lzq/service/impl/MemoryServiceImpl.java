package com.lzq.service.impl;

import com.lzq.dao.IMemoryDao;
import com.lzq.dao.IWordDao;
import com.lzq.domain.Memory;
import com.lzq.domain.Word;
import com.lzq.service.IMemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryServiceImpl implements IMemoryService {
    @Autowired
    IMemoryDao memoryDao;
    @Autowired
    IWordDao wordDao;

    @Override
    public void add(Memory memory) {
        memoryDao.add(memory);
    }

    @Override
    public void delete(Integer userId, Integer wordId) {
        memoryDao.delete(userId, wordId);
    }

    @Override
    public List<Word> queryForgetWords(Integer userId) {
        return wordDao.queryForgetWords(userId);
    }

    @Override
    public List<Memory> query(Memory memory) {
        return memoryDao.query(memory);
    }

    @Override
    public List<Memory> queryByUserIdWordId(int userId, int wordId) {
        return memoryDao.queryByUserIdWordId(userId, wordId);
    }
}
