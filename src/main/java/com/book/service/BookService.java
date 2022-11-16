package com.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.book.model.Book;
@Service
public interface BookService {
	
	public Book addBook(Book b);
	public List<Book> getAllBook();
	public Book getBookById(int id);
	public void deleteBookById(int id);
	public Book updateBookById(Book book,int id);
	public Book getBookByName(String bookName);
	public Book updateBook (Book book);
	public void deleteBook(Book book);
	public List<Book> getByBookName(String name);
	

}
