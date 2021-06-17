package com.example.library.dto;

import com.example.library.entity.Book;
import java.util.List;

public class AuthorDto {


    private Integer authorId;
    private String name;
    private List<Book> book;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public AuthorDto(Integer authorId, String name, List<Book> book) {
        this.authorId = authorId;
        this.name = name;
        this.book = book;
    }

    public  AuthorDto(){

    }
}
