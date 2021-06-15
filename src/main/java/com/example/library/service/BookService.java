package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.dto.BookDto;

import java.util.List;

public interface BookService {
    public Integer addBook(BookDto book);
    public List<Book> showAllBooks();
}
