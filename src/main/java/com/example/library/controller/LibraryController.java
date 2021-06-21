package com.example.library.controller;


import com.example.library.customexception.NotFoundException;
import com.example.library.dto.AuthorDto;
import com.example.library.dto.BookDto;
import com.example.library.dto.UserDto;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;
import com.example.library.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class LibraryController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @Autowired
    UserService userService;

    @PostMapping(value = "/authors")
    public ResponseEntity<AuthorDto> addAuthor(@RequestBody AuthorDto authorDto) throws NullPointerException{
        logger.info("Starting  addAuthor() methode");
        Author author = new Author();
        author.setName(authorDto.getName());
        var id= authorService.addAuthor(author);
        if(id == null){
            throw new NullPointerException("Error in adding the author");
        }
        author.setAuthorId(id);
        logger.info("addAuthor() methode ended");
        return ResponseEntity.ok().body(authorDto);
    }

    @GetMapping(value = "/authors")
    public ResponseEntity<List<AuthorDto>>  getAllAuthors(){
        logger.info("Starting  getAllAuthors() methode");
        List<Author> list = authorService.getAllAuthors();
        List<AuthorDto> authorDtos= new ArrayList<>();

        for(Author author:list){
            var authorDto = new AuthorDto(author.getAuthorId(),author.getName(),author.getBook());
            authorDtos.add(authorDto);
        }
        logger.info("getAllAuthors() methode ended");
        return  ResponseEntity.ok().body(authorDtos);

    }
    @GetMapping(value ="/authors/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Integer authorId) throws NotFoundException{
        logger.info("Starting  getAuthorById() methode");
        var author = authorService.getAuthorById(authorId);
        if(author == null){
            throw new NotFoundException("Author not found with id "+authorId.toString());
        }
        var authorDto = new AuthorDto(author.getAuthorId(),author.getName(),author.getBook());
        logger.info(" getAuthorById() methode ended");
        return ResponseEntity.ok().body(authorDto);
    }

    @PostMapping(value = "/books")
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto){
        logger.info("Starting  addBook() methode");
        Book book = new Book();
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

    @PostMapping(value = "/users")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        logger.info("Starting  addUser() methode");
        User user = new User();
        user.setName(userDto.getName());
        var userFromDb = userService.addUser(user);
        userDto.setUserId(userFromDb.getUserId());
        logger.info(" addUser() methode ended");
        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        logger.info("Starting  getAllUsers() methode");
        List<User> userList= userService.getAllUsers();
        List<UserDto> userDtos = new ArrayList<>();
        for(User user:userList){
            var userDto = new UserDto(user.getUserId(),user.getName(),user.getBook());
            userDtos.add(userDto);
        }
        logger.info(" getAllUsers() methode ended");
        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping(value = "/users/{id}")
     public ResponseEntity<UserDto> getUserById(@PathVariable Integer id){
        logger.info("Starting  getUserById() methode");
        var user = userService.getUserById(id);

        var userDto = new UserDto(user.getUserId(),user.getName(),user.getBook());
        logger.info(" getUserById() methode ended");
        return ResponseEntity.ok().body(userDto);
    }

    @PutMapping(value ="/subscribe")
    public ResponseEntity<BookDto> subscribedBooks(@RequestBody BookDto bookDto){
        logger.info("Starting  subscribedBooks() methode");
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setBookId(bookDto.getBookId());
        book.setUserId(bookDto.getUserId());
        book.setAuthorId(bookDto.getAuthorId());
        book.setDescription(bookDto.getDescription());
        var savedBook=userService.subscribeBook(book);
        logger.info(" subscribedBooks() methode ended");
        return ResponseEntity.ok().body(bookDto);
    }

}
