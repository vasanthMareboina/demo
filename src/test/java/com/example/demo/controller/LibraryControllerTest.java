package com.example.demo.controller;

import com.example.library.controller.LibraryController;
import com.example.library.dto.AuthorDto;
import com.example.library.entity.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.service.AuthorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LibraryControllerTest {

        @InjectMocks
        LibraryController libraryController;

        @Mock
        AuthorRepository authorRepository;

        protected MockMvc mvc;

        @LocalServerPort
        int randomServerPort;

        @Test
        void testGetAuthorListSuccess() throws URISyntaxException {

            RestTemplate restTemplate=new RestTemplate();

            final String baseUrl="http://localhost:"+randomServerPort+"/authors";

            URI uri=new URI(baseUrl);

            ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

            Assert.assertEquals(200, result.getStatusCodeValue());

        }
}
