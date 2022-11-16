package com.cab;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.book.model.Book;
import com.book.repository.BookRepository;
import com.book.service.BookSeviceImpl;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes={ServiceMockitoTest1.class})
public class ServiceMockitoTest1 {
	
	@InjectMocks
	public BookSeviceImpl bookService;
	
	@Mock
	public BookRepository bookRepo;
	
	@Test
	public void test_getAllBook()
	{
		when(bookRepo.findAll()).thenReturn(Stream.of(new Book(1,"Java","K.Sharma",1000),new Book(2,"CSS","M.Mishra",2000)).collect(Collectors.toList()));
		assertEquals(2,bookService.getAllBook().size());
	}
	
	@Test
	public void test_getBookByName()
	{
		String name="Java";
		when(bookRepo.findByBookName(name)).thenReturn(Stream.of(new Book(1,"Java","K.Sharma",1000),new Book(2,"CSS","M.Mishra",2000)).collect(Collectors.toList()));
		assertEquals(1,bookService.getByBookName(name).size());
		
	}

}
