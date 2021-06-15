package com.example.demo.controller;

import com.example.library.controller.LibraryController;
import com.example.library.dto.AuthorDto;
import com.example.library.dto.BookDto;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.service.AuthorService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class LibraryControllerTest {

    @InjectMocks
    LibraryController libraryController;

    @Mock
    AuthorRepository authorRepository;

    @InjectMocks
    AuthorService authorService;

    protected MockMvc mvc;


    @Test
    public void testGetAuthorById()  {

        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setAuthorId(1);
        book.setBookId(1);
        book.setDescription("Contains all the features till version 8");
        book.setName("JAVA");
        books.add(book);
        AuthorDto authorDto = new AuthorDto(1,"vasanth",books);
        Integer id = authorService.addAuthor(authorDto);
         Author author = authorService.getAuthorById(id);
        Assert.assertEquals("vasanth", author.getName());

    }

    @Test
    public void testAddAuthor(){
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setAuthorId(1);
        book.setBookId(1);
        book.setDescription("Contains all the features till version 8");
        book.setName("JAVA");
        books.add(book);
        AuthorDto authorDto = new AuthorDto(1,"vasanth",books);
        Integer id = authorService.addAuthor(authorDto);
        String status = null;
        if(id > 0){
             status = "Added Successfully";
        }
        Assert.assertEquals("Added Successfully", status);

    }
}
