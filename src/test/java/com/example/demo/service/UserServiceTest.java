package com.example.demo.service;

import com.example.library.DemoApplication;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.repository.BookRepository;
import com.example.library.repository.UserRepository;
import com.example.library.service.BookService;
import com.example.library.service.UserService;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;


import static org.mockito.Mockito.when;
@SpringBootTest(classes = DemoApplication.class)

public class UserServiceTest {

    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;


    @MockBean
    private UserRepository userRepository;




    @Test
    void getUsersTest() {

        var user = new User();
        user.setName("Vasanth");
        user.setUserId(1);
        when(userRepository.findAll()).thenReturn(Stream.of(user).collect(Collectors.toList()));
        Assertions.assertEquals(1, userService.getAllUsers().size());
    }

    @Test
    public void getUsersByIdTest() {

        var user = new User();
        user.setName("Vasanth");
        user.setUserId(1);
        when(userRepository.getById(1)).thenReturn(user);
        Assertions.assertEquals(user, userService.getUserById(1));
    }


    @Test
    void addUsersTest() {
        var user = new User();
        user.setName("Ashok");
        user.setUserId(1);
        Integer id =1;
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assertions.assertEquals(id,userService.addUser(user).getUserId());
    }

    @Test
    void subscribeBookTest(){

        var book = new Book();
        book.setName("Java");
        book.setBookId(1);
        book.setUserId(1);
        book.setAuthorId(1);
        book.setDescription("Contains all the information till Java 8");
        Mockito.when(bookRepository.save(book)).thenReturn(book);
        Assertions.assertEquals(book,userService.subscribeBook(book));
    }
}
