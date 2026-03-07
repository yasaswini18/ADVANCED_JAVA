package com.arcana.BookStoreRestApi.entity;

public class Books {
	private int id;
	private String title;
	private String author;
	private int yearPublished;
	private int numberOfPages;
	public Books()
	{
		
	}
	
	public Books(int id, String title, String author, int yearPublished, int numberOfPages) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.yearPublished = yearPublished;
		this.numberOfPages = numberOfPages;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
}
