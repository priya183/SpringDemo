package com.book.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	@NotEmpty
	@Size(min=3, message="Book name should be minimum of 4 characters.")
	public String bookName;
	@NotEmpty
	public String bookAuthor;
	@NonNull
	public int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String bookName, String bookAuthor, int price) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.price = price;
	}
	
}
