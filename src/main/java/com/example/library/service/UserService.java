package com.example.library.service;

import com.example.library.dto.UserDto;
import com.example.library.dto.BookDto;
import com.example.library.entity.Book;
import com.example.library.entity.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public List<User> getAllUsers();
    public Book subscribeBook(Book book);
    public User getUserById(Integer id);
}
