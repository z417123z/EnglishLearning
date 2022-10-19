package com.lzq.domain;

public class Bookshelf {
    private Integer id;
    private Integer userId;
    private Integer bookId;

    private Integer wordList;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getWordList() {
        return wordList;
    }

    public void setWordList(Integer wordList) {
        this.wordList = wordList;
    }
}
