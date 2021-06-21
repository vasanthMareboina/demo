package com.example.library.service;

import com.example.library.entity.Book;


import java.util.List;

public interface BookService {
    public Integer addBook(Book book);
    public List<Book> showAllBooks();
}
