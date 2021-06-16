package com.example.library.service;

import com.example.library.dto.UserDto;
import com.example.library.dto.BookDto;
import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.repository.BookRepository;
import com.example.library.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(UserDto user) {
        logger.info("Starting  addUser() methode");
        User userFromDb = new User();
        userFromDb.setName(user.getName());
        userFromDb = userRepository.save(userFromDb);
        logger.info(" addUser() methode ended");
        return userFromDb;
    }

    @Override
    public List<User> getAllUsers() {
        logger.info("Starting  getAllUsers() methode");
        List<User> userList = userRepository.findAll();
        logger.info(" getAllUsers() methode ended");
        return userList;
    }

    @Override
    public User getUserById(Integer id) {
        logger.info("Starting  getUserById() methode");
        try{
            User user = userRepository.getById(id);
            logger.info(" getUserById() methode ended");
            return user;
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("No User found with id "+id);
        }
    }

    @Override
    public Book subscribeBook(BookDto book) {
        logger.info("Starting  subscribeBook() methode");
        Book bookFromDb = new Book();
        bookFromDb.setAuthorId(book.getAuthorId());
        bookFromDb.setBookId(book.getBookId());
        bookFromDb.setDescription(book.getDescription());
        bookFromDb.setUserId(book.getBookId());
        bookFromDb = bookRepository.save(bookFromDb);
        logger.info(" subscribeBook() methode ended");
        return bookFromDb;
    }
}
