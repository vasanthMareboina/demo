package com.example.demo.controller;

import com.example.library.DemoApplication;
import com.example.library.controller.LibraryController;
import com.example.library.dto.AuthorDto;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.service.AuthorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.mockito.Mockito.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class LibraryControllerTest {

        @InjectMocks
        LibraryController libraryController;

        @Mock
        AuthorRepository authorRepository;

        @MockBean
        AuthorService authorService;

        protected MockMvc mvc;

        @LocalServerPort
        int randomServerPort;

        @Test
        public void testGetAuthorListSuccess() {

            Author author = new Author();
            author.setName("Vasanth");

            MockHttpServletRequest request = new MockHttpServletRequest();
            RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

            when(authorService.getAllAuthors()).thenReturn(Stream.of(author).collect(Collectors.toList()));

//            Employee employee = new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
//            ResponseEntity<Object> responseEntity = employeeController.addEmployee(employee);
//
//            assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
//            assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");

            //this.mockMvc.perform(get("/users/")).andExpect(status().isOK

        }
}
