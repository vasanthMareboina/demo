package com.example.demo.controller;

import com.example.library.dto.AuthorDto;
import com.example.library.entity.Book;
import com.example.library.service.AuthorService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

public class LibraryControllerTest {

    @InjectMocks
    AuthorService authorService;

    protected MockMvc mvc;


    @Test
    public void testGetAuthorById()  {

        List<Book> books = new ArrayList<>();
        var book = new Book();
        book.setAuthorId(1);
        book.setBookId(1);
        book.setDescription("Contains all the features till version 8");
        book.setName("JAVA");
        books.add(book);
        var authorDto = new AuthorDto(1,"vasanth",books);
        var id = authorService.addAuthor(authorDto);
         var author = authorService.getAuthorById(id);
        Assert.assertEquals("vasanth", author.getName());

    }

    @Test
    public void testAddAuthor(){
        List<Book> books = new ArrayList<>();
        var book = new Book();
        book.setAuthorId(1);
        book.setBookId(1);
        book.setDescription("Contains all the features till version 8");
        book.setName("JAVA");
        books.add(book);
        var authorDto = new AuthorDto(1,"vasanth",books);
        var id = authorService.addAuthor(authorDto);
        String status = null;
        if(id > 0){
             status = "Added Successfully";
        }
        Assert.assertEquals("Added Successfully", status);

    }
}
