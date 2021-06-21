package com.example.demo.controller;

import com.example.library.DemoApplication;
import com.example.library.controller.LibraryController;

import com.example.library.repository.AuthorRepository;
import com.example.library.service.AuthorService;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class LibraryControllerTest {

        @InjectMocks
        LibraryController libraryController;

        @Mock
        AuthorRepository authorRepository;

        @MockBean
        AuthorService authorService;

        protected MockMvc mvc;

        @LocalServerPort
        int randomServerPort;


}
