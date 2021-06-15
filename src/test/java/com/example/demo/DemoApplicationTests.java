package com.example.demo;

import com.example.demo.controller.LibraryControllerTest;
import com.example.library.controller.LibraryController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;

@SpringBootTest(classes = LibraryControllerTest.class)
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class DemoApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertDoesNotThrow(this::doNotThrowException);
	}

	private void doNotThrowException(){
		//This method will never throw exception
	}

}
