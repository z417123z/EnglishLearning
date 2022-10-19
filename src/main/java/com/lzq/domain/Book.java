package com.lzq.domain;

public class Book {
    private int id ;
    private String name;
    private String grade;
    private String picture;
    private String wordTable;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getWordTable() {
        return wordTable;
    }

    public void setWordTable(String wordTable) {
        this.wordTable = wordTable;
    }
}
