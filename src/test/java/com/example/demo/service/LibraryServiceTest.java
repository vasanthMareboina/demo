package com.example.demo.service;

import com.example.library.DemoApplication;
import com.example.library.dto.AuthorDto;
import com.example.library.dto.BookDto;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.lang.Nullable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class LibraryServiceTest {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @MockBean
    private AuthorRepository authorRepository;

    @MockBean
    private BookRepository bookRepository;

    public LibraryServiceTest() {
    }


    @Test
    public void getAuthorsTest() {

        Author author = new Author();
        author.setName("Vasanth");
        when(authorRepository.findAll()).thenReturn(Stream.of(author).collect(Collectors.toList()));
        assertEquals(1, authorService.getAllAuthors().size());
    }

    @Test
    public void getAuthorsByIdTest() {
        Integer authorId = 1;
        Author author = new Author();
        author.setAuthorId(authorId);
        when(authorRepository.findById(authorId)).thenReturn(java.util.Optional.of(author));
        assertEquals(author, authorService.getAuthorById(authorId));
    }

    @Test
    public void addAuthorsTest() {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setName("Ashok");
        Author author = new Author();
        author.setName("Ashok");
        author.setAuthorId(1);
        when(authorRepository.save(author)).thenReturn(author);;
        assertEquals(1, java.util.Optional.ofNullable(authorService.addAuthor(authorDto)));
    }


    @Test
    public void addBooksTest(){
        Book book = new Book();
        book.setName("Java");
        Integer id =1;
        book.setBookId(id);
        BookDto bookDto = new BookDto();
        bookDto.setName("Java");
        when(bookRepository.save(book)).thenReturn(Stream.of(book).findFirst().get());
        assertEquals(id,bookService.addBook(bookDto));
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
}