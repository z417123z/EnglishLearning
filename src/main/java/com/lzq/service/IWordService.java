package com.lzq.service;

import com.lzq.domain.BookWord;
import com.lzq.domain.Word;

import java.util.List;

public interface IWordService {

    /**
     * 查书中单词表
     * @param word
     * @param pageNum
     * @param pageSize
     * @param bookId
     * @return
     * @throws Exception
     */
    List<Word> queryWordList(Word word, int pageNum, int pageSize, int bookId) throws Exception;

    /**
     * 查单词总表
     * @param word
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<Word> queryAllWords(Word word, int pageNum, int pageSize)throws Exception;

    /**
     * 添加单词
     * @param word
     * @return
     */
    int insertWord(Word word);

    /**
     * 批量添加单词到书
     * @param bookWordList
     * @return
     */
    int insertWordToBook(List<BookWord> bookWordList);

    /**
     *添加单词到书
     * @param bookWord
     */
    void add(BookWord bookWord);

    /**
     * 查中间表
     * @param bookWord
     * @return
     */
    List<BookWord> queryMid(BookWord bookWord);

    /**
     * 释义查询
     * @param translation
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Word> queryWordByTranslation(String translation, int pageNum, int pageSize);

    /**
     * 名称模糊查询
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Word> queryWordByName(String name, int pageNum, int pageSize);

    /**
     * 书id查中间表
     * @param bookId
     * @return
     */
    List<BookWord> queryByBookId(Integer bookId);

    /**
     * 根据id查单词
     * @param id
     * @return
     */
    Word queryWordById(Integer id);

    /**
     * 更新单词
     * @param word
     */
    void updateWord(Word word);

    /**
     * 书id和单词id查中间表
     * @param bookId
     * @param wordId
     * @return
     */
    List<BookWord> queryMidByBookIdWordId(int bookId, int wordId);

    /**
     * 从书中删单词
     */
    void deleteWordFromBook(int bookId, int wordId);

    /**
     * 管理员查书中单词
     * @param bookId
     * @param name
     * @param page
     * @param rows
     * @return
     */
    List<Word> queryWordListByName(int bookId, String name, int page, int rows);
}
