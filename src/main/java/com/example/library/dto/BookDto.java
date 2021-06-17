package com.example.library.dto;

public class BookDto {
    private Integer bookId;
    private String name;
    private String description;
    private Integer authorId;

    public Integer getAuthorId() {
        return authorId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookIdId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }


    public BookDto(Integer bookId, String name, String description, Integer authorId) {
        this.bookId = bookId;
        this.name = name;
        this.description = description;
        this.authorId = authorId;
    }

    public BookDto(){

    }
}
