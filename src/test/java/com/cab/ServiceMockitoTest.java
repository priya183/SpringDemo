package com.cab;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.book.model.Book;
import com.book.repository.BookRepository;
import com.book.service.BookSeviceImpl;


//if we want to test the method order wise then add this annotation
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes={ServiceMockitoTest.class})
public class ServiceMockitoTest {
	
	@Mock
	BookRepository bookRepo;
	
	@InjectMocks
	BookSeviceImpl bookService;
	
	
	public List<Book> bookList;
	public Optional<Book> list;
	
	@Test
	@Order(1)
	public void test_getAllBook()
	{
	 bookList=new ArrayList<Book>();
	 bookList.add(new Book(1,"HTML","R.Sharma",1200));
	 bookList.add(new Book(2,"Java","K.Narayan",2000));
	 
	 when(bookRepo.findAll()).thenReturn(bookList);
	 
	 assertEquals(2,bookService.getAllBook().size());
		
	}

	@Test
	@Order(2)
	public void test_getBookById()
	{
	 bookList=new ArrayList<Book>();
	 bookList.add(new Book(1,"HTML","R.Sharma",1200));
	 bookList.add(new Book(2,"Java","K.Narayan",2000));
	 int bookId=1;
	 when(bookRepo.findAll()).thenReturn(bookList);
	 
	 assertEquals(bookId,bookService.getBookById(bookId).getId());
		
	}
	/*@Test
	@Order(7)
	public void test_getById()
	{
	 bookList=new ArrayList<Book>();
	 bookList.add(new Book(1,"HTML","R.Sharma",1200));
	 bookList.add(new Book(2,"Java","K.Narayan",2000));
	 int bookId=1;
	 when(bookRepo.findById(bookId)).thenReturn(bookList);
	 
	 assertEquals(bookId,bookService.getBookById(bookId).getId());
		
	}*/
	
	@Test
	@Order(3)
	public void test_findByBookName()
	{
	 bookList=new ArrayList<Book>();
	 bookList.add(new Book(1,"HTML","R.Sharma",1200));
	 bookList.add(new Book(2,"Java","K.Narayan",2000));
	
	 String bookName="HTML";
	 when(bookRepo.findAll()).thenReturn(bookList);
	 
	 assertEquals(bookName,bookService.getBookByName(bookName).getBookName());
		
	}
	@Test
	@Order(4)
	public void test_addBook()
	{
	
	 Book book=new Book(3,"CSS","R.Sharma",2200);
	 when(bookRepo.save(book)).thenReturn(book);
	 
	 assertEquals(book,bookService.addBook(book));
		
	}

	@Test
	@Order(5)
	public void test_updateBook()
	{
	
	 Book book=new Book(3,"CSS","R.Sharma",2200);
	 when(bookRepo.save(book)).thenReturn(book);
	 
	 assertEquals(book,bookService.updateBook(book));
		
	}
	
	@Test
	@Order(6)
	public void test_deleteBook()
	{
	
	 Book book=new Book(3,"CSS","R.Sharma",2200);
	 bookService.deleteBook(book);
	 
	 verify(bookRepo, times(1)).delete(book);		
	}

	

}

