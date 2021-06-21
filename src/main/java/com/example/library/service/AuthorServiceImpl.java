package com.example.library.service;

import com.example.library.entity.Author;

import com.example.library.repository.AuthorRepository;
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
    public Integer addAuthor(Author author) {

        logger.info("Starting  addAuthor() methode");
        var authorFromDb   = new Author();

        authorFromDb.setName(author.getName());
       // System.out.println(author.getName());
         authorFromDb = authorRepository.save(author);
         try{

                 var id = authorFromDb.getAuthorId();
                 logger.info("addAuthor() methode ended");
                 return id;

         }
         catch (NullPointerException e){
             throw new NullPointerException(e.getMessage());
         }


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
            var author= authorRepository.getById(id);
            logger.info("getAuthorById() methode ended");
            return author;
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("No Author found with id "+id);
        }
    }

}
