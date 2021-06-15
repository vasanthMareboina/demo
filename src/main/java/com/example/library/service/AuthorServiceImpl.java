package com.example.library.service;

import com.example.library.entity.Author;
import com.example.library.dto.AuthorDto;
import com.example.library.entity.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public Integer addAuthor(AuthorDto author) {

        logger.info("Starting  addAuthor() methode");
        Author authorFromDb   = new Author();
        authorFromDb.setName(author.getName());
         authorFromDb = authorRepository.save(authorFromDb);
        logger.info("addAuthor() methode ended");
        return authorFromDb.getAuthorId();
    }

    @Override
    public List<Author> getAllAuthors() {
        logger.info("Starting  getAllAuthors() methode");
        List<Author> list = authorRepository.findAll();
        logger.info("getAllAuthors() methode ended");
        return list;
    }


    @Override
    public Author getAuthorById(Integer id) {
        logger.info("Starting  getAuthorById() methode");
        try{
            Author author= authorRepository.getById(id);
            logger.info("getAuthorById() methode ended");
            return author;
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("No Author found with id "+id);
        }

    }

}
