package com.example.demo.service;

import com.example.library.DemoApplication;
import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;


import static org.mockito.Mockito.when;

@SpringBootTest(classes = DemoApplication.class)
public class BookServiceTest {



    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;


    @Test
    void addBooksTest(){
        var book = new Book();
        book.setName("Java");
        Integer id =1;
        book.setBookId(id);
        when(bookRepository.save(book)).thenReturn(book);
        Assertions.assertEquals(id,bookService.addBook(book));
    }

    @Test
    void showAllBooksTest(){
        var book = new Book();
        book.setName("Java");
        book.setBookId(1);
        book.setDescription("Contains all the information till Java 8");
        when(bookRepository.findAll()).thenReturn(Stream.of(book).collect(Collectors.toList()));
        Assertions.assertEquals(1, bookService.showAllBooks().size());
    }
}
