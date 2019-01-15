package com.project.app;

import java.util.List;

public interface BookDAO {
	public void createBook(Book book);    
	public Book getBookById(long id);
    public List<Book> getAllBooks();    
    public void updateBook(Book book);    
    public void deleteBook(long id);
}
