package com.example.library.service;

import com.example.library.entity.Author;


import java.util.List;

public interface AuthorService {
    public Integer addAuthor(Author author);
    public List<Author>  getAllAuthors();
    public Author getAuthorById(Integer id);
}
