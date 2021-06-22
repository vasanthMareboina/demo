package com.example.library.controller;


import com.example.library.dto.BookDto;
import com.example.library.dto.UserDto;
import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;
    @PostMapping(value = "/users")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        logger.info("Starting  addUser() methode");
        var user = new User();
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
        var book = new Book();
        book.setName(bookDto.getName());
        book.setBookId(bookDto.getBookId());
        book.setUserId(bookDto.getUserId());
        book.setAuthorId(bookDto.getAuthorId());
        book.setDescription(bookDto.getDescription());
        userService.subscribeBook(book);
        logger.info(" subscribedBooks() methode ended");
        return ResponseEntity.ok().body(bookDto);
    }

}
