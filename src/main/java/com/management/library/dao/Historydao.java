package com.management.library.dao;

import java.util.List;

import com.management.library.model.BookidDetails;
import com.management.library.model.History;
import com.management.library.model.Request;

public interface Historydao {
	List<History> getAllHistory ();
	public int addHistory(Request h);
	
	public int getBookfromhistorybyid(int bookid);
	
	public BookidDetails getDetailbyBookid(int bookid);
	
}
