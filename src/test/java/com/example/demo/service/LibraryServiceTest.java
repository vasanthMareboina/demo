package com.example.demo.service;

import com.example.library.DemoApplication;
import com.example.library.dto.AuthorDto;
import com.example.library.dto.BookDto;
import com.example.library.dto.UserDto;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.repository.UserRepository;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;
import com.example.library.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class LibraryServiceTest {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @MockBean
    private AuthorRepository authorRepository;

    @MockBean
    private UserRepository userRepository;


    @MockBean
    private BookRepository bookRepository;

    public LibraryServiceTest() {
    }

    @BeforeTestExecution


    @Test
    public void getAuthorsTest() {

        Author author = new Author();
        author.setName("Vasanth");
        author.setAuthorId(1);
        when(authorRepository.findAll()).thenReturn(Stream.of(author).collect(Collectors.toList()));
        assertEquals(1, authorService.getAllAuthors().size());
    }

//    @Test
//    public void getAuthorsByIdTest() {
//        Integer authorId = 1;
//        Author author = new Author();
//        author.setName("Vasanth");
//        author.setAuthorId(authorId);
//        when(authorRepository.findById(authorId)).thenReturn(java.util.Optional.of(author));
//        assertEquals(author, authorService.getAuthorById(authorId));
//    }

    @Test
    public void addAuthorsTest() {
        Author author = new Author();
        author.setName("Ashok");
        author.setAuthorId(1);
        Integer id =1;
        long id1 =1;
        System.out.println(author.getName()+author.getBook());
        Mockito.when(authorRepository.save(author)).thenReturn(author);
        assertEquals(id,authorService.addAuthor(author));
    }


    @Test
    public void addBooksTest(){
        Book book = new Book();
        book.setName("Java");
        Integer id =1;
        book.setBookId(id);
        when(bookRepository.save(book)).thenReturn(book);
        assertEquals(id,bookService.addBook(book));
    }

    @Test
    public void showAllBooksTest(){
        Book book = new Book();
        book.setName("Java");
        book.setBookId(1);
        long id =1;
        book.setDescription("Contains all the information till Java 8");
        when(bookRepository.findAll()).thenReturn(Stream.of(book).collect(Collectors.toList()));
        assertEquals(id, (long) (bookService.showAllBooks().size()));
    }

    @Test
    public void getUsersTest() {

        User user = new User();
        user.setName("Vasanth");
        user.setUserId(1);
        when(userRepository.findAll()).thenReturn(Stream.of(user).collect(Collectors.toList()));
        assertEquals(1, userService.getAllUsers().size());
    }


    @Test
    public void addUsersTest() {
        User user = new User();
        user.setName("Ashok");
        user.setUserId(1);
        Integer id =1;
        Mockito.when(userRepository.save(user)).thenReturn(user);
        assertEquals(id,userService.addUser(user).getUserId());
    }

    @Test
    public void subscribeBookTest(){

        Book book = new Book();
        book.setName("Java");
        book.setBookId(1);
        book.setUserId(1);
        book.setAuthorId(1);
        book.setDescription("Contains all the information till Java 8");
        Mockito.when(bookRepository.save(book)).thenReturn(book);
        assertEquals(book,userService.subscribeBook(book));
    }


}