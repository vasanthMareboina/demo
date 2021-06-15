package com.example.library.dto;

import com.example.library.entity.Book;

import javax.persistence.*;
import java.util.List;

public class UserDto {

    private Integer UserId;
    private String name;
    private List<Book> book;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public UserDto(Integer userId, String name, List<Book> book) {
        UserId = userId;
        this.name = name;
        this.book = book;
    }
}
