package com.management.library.dao;

import java.util.List;

import com.management.library.model.Book;

public interface Bookdao {
	
	int save(Book book);
    Book findById(int bookId);
    List<Book> findAll();
    int update(Book book);
    int delete(Long bookId);

}
