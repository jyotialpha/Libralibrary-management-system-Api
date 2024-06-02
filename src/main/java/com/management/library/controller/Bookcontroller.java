package com.management.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.management.library.daoimpliment.BookDAOImp;
import com.management.library.model.Book;
import com.management.library.model.Response;

@RestController
public class Bookcontroller {
	
	@Autowired
	BookDAOImp bo;
	
	@GetMapping(path="/Bookdetails")
	public List<Book> findbookDetails(){
		
		List<Book> Details = bo.findAll();
		
		return Details;
	}
	
	@PostMapping(path="/AddBooks")
	public Response addBookstoLib(@RequestBody Book book) {
		
	Response rs =new Response();	
	
	if(book.getBookname().equalsIgnoreCase("") || book.getAuthor().equalsIgnoreCase("")) {
		rs.setPassmsg("please fill your bookname or author");
		rs.setStatus(true);
		return rs;
	}
		int   add = bo.save(book);
		if(add==0) {
			rs.setPassmsg("data is not added");
			rs.setStatus(false);
			return rs;
		}
		rs.setPassmsg("Data added Successfully");
		rs.setStatus(true);
		return  rs;
		
	}

    @PostMapping(path="/updateBook")
	public Response updateBook(@RequestBody Book book) {
		Response rs = new Response();
		if(book.getAuthor().equalsIgnoreCase("")||book.getBookname().equalsIgnoreCase("")||book.getPage()==0||book.getQuantity()==0) {
			rs.setPassmsg("NUll value");
			rs.setStatus(true);
			return rs;
		}
		int up = bo.update(book);
		
		if(up == 0) {
			rs.setPassmsg("Data is not updated");
			rs.setStatus(false);
			return rs;
		}
		rs.setPassmsg("Data updated success fully");
		rs.setStatus(true);
		return rs;
	}
	
    @DeleteMapping(path="/deleteBookRecord/{bookid}")
    public Response deletebookRecord(@PathVariable("bookid") Long bookid) {
    	Response rs =  new Response();
    	
    	if(bookid==0) {
    		rs.setPassmsg("plz enter an bookid");
    		rs.setStatus(false);
    		return rs;
    	}
    		int delete = bo.delete(bookid);
    		
    	if(delete==0) {
    		rs.setPassmsg("data is not deleted");
    		rs.setStatus(false);
    		return rs;
    	}	
    	rs.setPassmsg("data is deleted succesfully");
		rs.setStatus(true);
		return rs;
    }
    
    @PutMapping(path="/getBookbyID/{bookid}")
    public Book getBookdetailsbyBookid(@PathVariable("bookid") int bookid) {
  
    	Book b = bo.findById(bookid);
		return b;
    }
    
    
    
}
