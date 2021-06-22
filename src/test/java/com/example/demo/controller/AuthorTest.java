package com.example.demo.controller;

import com.example.library.controller.AuthorController;
import com.example.library.entity.Author;
import com.example.library.dto.AuthorDto;
import com.example.library.service.AuthorService;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



public class AuthorTest {

    @Autowired
    AuthorController authorController;

    @MockBean
    AuthorService authorService;

    @Test
    public void testAddAuthor()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Author author = new Author();
        author.setName("Vasanth");
        author.setAuthorId(1);
        AuthorDto authorDto = new AuthorDto();
        authorDto.setName("Vasanth");
        Mockito.when(authorService.addAuthor(author)).thenReturn(1);
        ResponseEntity<AuthorDto> responseEntity = authorController.addAuthor(authorDto);
        Assertions.assertEquals(authorDto, responseEntity.getBody());
    }
}
