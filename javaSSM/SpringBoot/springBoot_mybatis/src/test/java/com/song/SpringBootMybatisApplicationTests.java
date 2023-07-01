package com.song;

import com.song.dao.BookDao;
import com.song.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMybatisApplicationTests {

	@Autowired
	private BookDao bookDao;

	@Test
	void testGetById() {
		Book book = bookDao.getById(1);
		System.out.println(book);
	}

	@Test
	void testGetAll() {
		List<Book> all =  bookDao.getAll();
		System.out.println(all);
	}
}
