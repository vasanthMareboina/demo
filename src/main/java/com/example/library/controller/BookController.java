package com.example.library.controller;

import com.example.library.dto.BookDto;
import com.example.library.entity.Book;
import com.example.library.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookService bookService;


    @PostMapping(value = "/books")
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto){
        logger.info("Starting  addBook() methode");
        var book = new Book();
        book.setName(bookDto.getName());
        book.setDescription(bookDto.getDescription());
        book.setAuthorId(bookDto.getAuthorId());
        var id = bookService.addBook(book);
        bookDto.setBookIdId(id);
        logger.info(" addBook() methode ended");
        return ResponseEntity.ok().body(bookDto);
    }

    @GetMapping(value = "/books")
    public ResponseEntity<List<BookDto>> getAllBooks(){
        logger.info("Starting  getAllBooks() methode");
        List<Book> bookList = bookService.showAllBooks();
        List<BookDto> bookDtos = new ArrayList<>();

        for(Book book:bookList){
            var bookDto = new BookDto(book.getBookId(),book.getName(),book.getDescription(),book.getAuthorId());
            bookDtos.add(bookDto);
        }
        logger.info(" getAllBooks() methode ended");
        return ResponseEntity.ok().body(bookDtos);
    }

}
