package com.example.library.service;

import com.example.library.entity.Book;

import com.example.library.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Integer addBook(Book book) {
        logger.info("Starting  addBook() methode");
        book = bookRepository.save(book);
        logger.info(" addBook() methode ended");
        return book.getBookId();
    }

    @Override
    public List<Book> showAllBooks() {
        logger.info("Starting  showAllBooks() methode");
        List<Book> bookList = bookRepository.findAll();
        logger.info(" showAllBooks() methode ended");
        return bookList;
    }
}
