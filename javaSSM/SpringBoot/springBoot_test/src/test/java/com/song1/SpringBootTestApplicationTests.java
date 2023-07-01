package com.song1;

import com.song.SpringBootTestApplication;
import com.song.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//只加载同名包下，不同包下需指定
@SpringBootTest(classes = SpringBootTestApplication.class)
class SpringBootTestApplicationTests {

	@Autowired
	private BookService bookService;
	@Test
	public void save() {
		bookService.save();
	}

}
