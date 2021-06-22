package com.example.demo.service;

import com.example.library.DemoApplication;
import com.example.library.entity.Author;

import com.example.library.repository.AuthorRepository;
import com.example.library.service.AuthorService;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestExecution;


import java.util.stream.Collectors;
import java.util.stream.Stream;



import static org.mockito.Mockito.*;

@SpringBootTest(classes = DemoApplication.class)
public class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @MockBean
    private AuthorRepository authorRepository;

    public AuthorServiceTest() {
    }

    @BeforeTestExecution


    @Test
     public void getAuthorsTest() {

        var author = new Author();
        author.setName("Vasanth");
        author.setAuthorId(1);
        when(authorRepository.findAll()).thenReturn(Stream.of(author).collect(Collectors.toList()));
        Assertions.assertEquals(1, authorService.getAllAuthors().size());
    }

    @Test
    public void addAuthorsTest() {
        var author = new Author();
        author.setName("Ashok");
        author.setAuthorId(1);
        Integer id =1;
        long id1 =1;
        System.out.println(author.getName()+author.getBook());
        Mockito.when(authorRepository.save(author)).thenReturn(author);
        Assertions.assertEquals(id,authorService.addAuthor(author));
    }






}