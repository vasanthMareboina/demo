package com.example.demo.controller;

import com.example.library.DemoApplication;
import com.example.library.controller.AuthorController;
import com.example.library.customexception.NotFoundException;
import com.example.library.dto.AuthorDto;
import com.example.library.entity.Author;
import com.example.library.service.AuthorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = DemoApplication.class)
class AuthorControllerTest {

    @MockBean
    private AuthorService authorService;

    private MockMvc mockMvc;

    @Autowired
    private AuthorController authorController;

    private static ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
     void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();

    }

    @Test
     void getAuthorsTest() throws Exception {

        var author = new Author();
        author.setAuthorId(1);
        author.setName("name1");

        when(authorService.getAllAuthors()).thenReturn(
                Stream.of(author).collect(Collectors.toList()));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/authors")
                .accept(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json("[{authorId:1,name:name1,book:null}]"));

    }

    @Test
    void getAuthorsByIdTest() {

        var author = new Author();
        author.setName("name1");
        author.setAuthorId(1);
        when(authorService.getAuthorById(1)).thenReturn(
                author);

        RequestBuilder request = MockMvcRequestBuilders
                .get("/authors/1");

        try{
            this.mockMvc.perform(request)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(content().json("{authorId:1,name:name1,book:null}"));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    void addAuthorsTest() throws Exception {
        var author = new Author();
        author.setName("name1");

        Mockito.when(authorService.addAuthor(ArgumentMatchers.any())).thenReturn(1);
        String json = mapper.writeValueAsString(author);
        mockMvc.perform(MockMvcRequestBuilders.post("/authors").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.authorId", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.name", Matchers.equalTo("name1")));
    }

    @Test
    void addAuthorsErrorTest() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders
                .post("/authors")
                .content("hello")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(request)
                .andExpect(status().isBadRequest());
    }

    @Test
    void getAuthorsByIdErrorTest() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders
                .get("/authors/100")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        try{
            this.mockMvc.perform(request)
                    .andExpect(status().isBadRequest());
        }
        catch (Exception e){
            Assertions.assertTrue(e.getMessage().contains("Author not found"));
        }


    }




}
