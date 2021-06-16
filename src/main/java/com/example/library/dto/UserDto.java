package com.example.library.dto;

import com.example.library.entity.Book;
import java.util.List;

public class UserDto {

    private Integer userId;
    private String name;
    private List<Book> book;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Book> getBook() {
        return book;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public UserDto(Integer userId, String name, List<Book> book) {
        this.userId = userId;
        this.name = name;
        this.book = book;
    }
}
