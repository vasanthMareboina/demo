package com.example.library.service;


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
    public User addUser(User user) {
        user = userRepository.save(user);
        logger.info(" addUser() methode ended");
        return user;
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
            var user = userRepository.getById(id);
            logger.info(" getUserById() methode ended");
            return user;
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("No User found with id "+id);
        }
    }

    @Override
    public Book subscribeBook(Book book) {
        logger.info("Starting  subscribeBook() methode");
        book = bookRepository.save(book);
        logger.info(" subscribeBook() methode ended");
        return book;
    }
}
