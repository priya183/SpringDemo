package com.book.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.Book;
import com.book.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	public BookService bookService;
	@PostMapping("/addBook")
	public Book addBook(@Valid @RequestBody Book book)
	{
		Book b=bookService.addBook(book);
		return b;
	}
	@GetMapping("/getAllBook")
	public List<Book> getAllBook()
	{
		List<Book> allbook=bookService.getAllBook();
		return allbook;
	}
	@GetMapping("/getBookById/{id}")
	public Book getbyId(@PathVariable("id") int id)
	{
		Book book=bookService.getBookById(id);
		return book;
	}
	@GetMapping("/getBookByName/{bookName}")
	public Book getbyBookName(@PathVariable("bookName") String bookName)
	{
		Book book=bookService.getBookByName(bookName);
		return book;
	}
	
	@GetMapping("/getByBookName/{bookName}")
	public List<Book> getWithBookName(@PathVariable("bookName") String bookName)
	{
		List<Book> book=bookService.getByBookName(bookName);
		return book;
	}
	
    @DeleteMapping("/deleteById/{id}")
    public String deleteBookById(@PathVariable("id") int id)
    {
    	bookService.deleteBookById(id);
    	return "Book of id "+id+" is deleted.";
    }

    @DeleteMapping("/deleteBook")
    public String deleteBook(@RequestBody Book book)
    {
    	bookService.deleteBook(book);
    	return "Book "+book +" is deleted.";
    }
    @PutMapping("/updateBookById/{id}")
    public Book updateBook(@RequestBody Book book,@PathVariable int id)
    {
    Book b=bookService.updateBookById(book, id);
    return b;
    }
    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book)
    {
    Book b=bookService.updateBook(book);
    return b;
    }
}
