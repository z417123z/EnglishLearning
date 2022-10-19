package com.lzq.dao;

import com.lzq.domain.Word;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IWordDao {
    List<Word> query(@Param("bookId") Integer bookId);

    List<Word> queryAll(Word word);

    int insertWord(Word word);

    List<Word> queryWordByTranslation(@Param("translation") String translation);

    List<Word> queryWordByName(@Param("name") String name);

    Word queryWordById(@Param("id") Integer id);

    void updateWord(Word word);

    List<Word> queryForgetWords(@Param("userId") Integer userId);

    List<Word> queryWordListByName(@Param("bookId") int bookId,
                                   @Param("name") String name);
}
