package com.example.library.controller;

import com.example.library.customexception.NotFoundException;
import com.example.library.dto.AuthorDto;
import com.example.library.entity.Author;
import com.example.library.service.AuthorService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class AuthorController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    AuthorService authorService;


    @PostMapping(value = "/authors")
    public ResponseEntity<AuthorDto> addAuthor(@RequestBody AuthorDto authorDto) throws NullPointerException{
        logger.info("Starting  addAuthor() methode");
        var author = new Author();
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
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Integer authorId) throws NotFoundException {
        logger.info("Starting  getAuthorById() methode");
        var author = authorService.getAuthorById(authorId);
        if(author == null){
            throw new NotFoundException("Author not found with id "+authorId.toString());
        }
        var authorDto = new AuthorDto(author.getAuthorId(),author.getName(),author.getBook());
        logger.info(" getAuthorById() methode ended");
        return ResponseEntity.ok().body(authorDto);
    }
}
