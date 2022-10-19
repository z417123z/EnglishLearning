package com.lzq.service.impl;

import com.github.pagehelper.PageHelper;
import com.lzq.dao.IBookWordDao;
import com.lzq.dao.IMemoryDao;
import com.lzq.dao.IWordDao;
import com.lzq.domain.BookWord;
import com.lzq.domain.Word;
import com.lzq.service.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements IWordService {
    @Autowired
    private IWordDao wordDao;
    @Autowired
    private IBookWordDao bookWordDao;
    @Autowired
    private IMemoryDao memoryDao;

    @Override
    public List<Word> queryWordList( Word word,int pageNum, int pageSize, int bookId) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        return wordDao.query(bookId);
    }

    @Override
    public List<Word> queryAllWords(Word word, int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        return wordDao.queryAll(word);
    }

    @Override
    public int insertWord(Word word) {
        return wordDao.insertWord(word);
    }

    @Override
    public int insertWordToBook(List<BookWord> bookWordList) {
        return bookWordDao.insertWordToBook(bookWordList);
    }

    @Override
    public void add(BookWord bookWord) {
        bookWordDao.add(bookWord);
    }

    @Override
    public List<BookWord> queryMid(BookWord bookWord) {
        return bookWordDao.query(bookWord);
    }

    @Override
    public List<Word> queryWordByTranslation(String translation, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        translation = '%' + translation + '%';
        return wordDao.queryWordByTranslation(translation);
    }

    @Override
    public List<Word> queryWordByName(String name, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        name = name + '%';
        return wordDao.queryWordByName(name);
    }

    @Override
    public List<BookWord> queryByBookId(Integer bookId) {
        return bookWordDao.queryByBookId(bookId);
    }

    @Override
    public Word queryWordById(Integer id) {
        return wordDao.queryWordById(id);
    }

    @Override
    public void updateWord(Word word) {
        wordDao.updateWord(word);
    }

    @Override
    public List<BookWord> queryMidByBookIdWordId(int bookId, int wordId) {
        return bookWordDao.queryMidByBookIdWordId(bookId, wordId);
    }

    @Override
    public void deleteWordFromBook(int bookId, int wordId) {
        bookWordDao.deleteWordFromBook(bookId, wordId);
    }

    @Override
    public List<Word> queryWordListByName(int bookId, String name, int page, int rows) {
        PageHelper.startPage(page, rows);
        name = name + '%';
        return wordDao.queryWordListByName(bookId, name);
    }


}
