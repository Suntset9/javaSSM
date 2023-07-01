package com.song;

import com.song.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootTestApplicationTests {

	@Autowired
	private BookService bookService;
	@Test
	public void save() {
		bookService.save();
	}

}
