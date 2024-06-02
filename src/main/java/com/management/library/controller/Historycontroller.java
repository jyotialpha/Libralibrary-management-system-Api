package com.management.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.management.library.daoimpliment.Historydaoimpl;
import com.management.library.model.BookidDetails;
import com.management.library.model.History;

@RestController
public class Historycontroller {
	@Autowired
	Historydaoimpl h;
	
	@GetMapping(path="/getAllhistory")
	public List<History> getallHistory(){
		List<History> history = h.getAllHistory();
		return history;
	}
	
	@PostMapping(path="/getBokquantitybyid/{bookid}")
	public int getBokquantitybyid(@PathVariable("bookid") int bookid) {
		
		int bookquantity = h.getBookfromhistorybyid(bookid);
		return bookquantity;
	}
	
	
	@PostMapping(path="/getBokdetaildbyid/{bookid}")
	public BookidDetails getDetailbyBookid(@PathVariable ("bookid") int bookid) {
		
		BookidDetails bookquantity = h.getDetailbyBookid(bookid);
		return bookquantity;
	}

}

