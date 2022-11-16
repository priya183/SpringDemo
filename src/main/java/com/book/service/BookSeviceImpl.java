package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.model.Book;
import com.book.repository.BookRepository;


@Service
public class BookSeviceImpl implements BookService{
	
	@Autowired
	public BookRepository bookRepo;

	@Override
	public Book addBook(Book b) {
		Book book=bookRepo.save(b);
		return book;
	}

	@Override
	public List<Book> getAllBook() {
		List<Book> list=bookRepo.findAll();
		return list;
	}

	/*@Override
	public Book getBookById(int id) {
		Book b=bookRepo.findById(id).get();
		return b;
	}*/
	
	@Override
	public Book getBookById(int id) {
		List<Book> list=bookRepo.findAll();
		Book b = null;
		for(Book book:list)
		{
			if(book.getId()==id)
			{
				b=book;
			}
		}
		return b;
	}

	@Override
	public void deleteBookById(int id) {
		bookRepo.deleteById(id);
		
	}

	@Override
	public Book updateBookById(Book book, int id) {
		Optional<Book> bk=bookRepo.findById(id);
		if(bk.isPresent())
		{
			Book b=bk.get();
			b.setBookName(book.getBookName());
			b.setBookAuthor(book.getBookAuthor());
			b.setPrice(book.getPrice());
			bookRepo.save(b);
		}
		else
		{
			System.out.println("Book not available");
		}
		System.out.println("Book Updating Successfully ");
		return book;
	}

	/*@Override
	public Book findByBookName(String bookName) {
		Book list=bookRepo.findByBookName(bookName);
		return list;
	}*/
	
	@Override
	public Book getBookByName(String bookName) {
		List<Book> list=bookRepo.findAll();
		Book book = null;
		for(Book b:list)
		{
			if(b.getBookName().equalsIgnoreCase(bookName))
			{
				book=b;
			}
		}
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		
		return bookRepo.save(book);
	}

	@Override
	public void deleteBook(Book book) {
		bookRepo.delete(book);
	}

	@Override
	public List<Book> getByBookName(String name) {
		 return bookRepo.findByBookName(name);
	}
}

