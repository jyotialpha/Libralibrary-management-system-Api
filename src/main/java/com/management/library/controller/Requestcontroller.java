package com.management.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.management.library.daoimpliment.BookDAOImp;
import com.management.library.daoimpliment.Historydaoimpl;
import com.management.library.daoimpliment.RequestDaoimpl;
import com.management.library.model.Book;
import com.management.library.model.HistoryCountModel;
import com.management.library.model.HistoryCountReturn;
import com.management.library.model.Request;
import com.management.library.model.Response;

@RestController
public class Requestcontroller {
	
	@Autowired
	RequestDaoimpl rd;
	
	@Autowired
    BookDAOImp bdi;
	
	@Autowired
	Historydaoimpl his;
	
	@PostMapping(path="/addbookRequest")
	public ResponseEntity<Response> addRequest(@RequestBody Request request) {
		
		Response  rs = new Response();
		
		if(request.getBookid() == 0|| request.getStartdate()== null||request.getEnddate()== null){
			rs.setPassmsg("Null value");
			rs.setStatus(false);
			return new ResponseEntity<Response>(rs, HttpStatus.OK);			
		}
		
		int i = rd.add(request);
		
		if(i==0) {
			rs.setPassmsg("data is not added");
			rs.setStatus(false);
			return new ResponseEntity<Response>(rs, HttpStatus.OK);
		}
		
		rs.setPassmsg("Data added successfully");
		rs.setStatus(true);
		return new ResponseEntity<Response>(rs, HttpStatus.OK);		
	}
	
	@GetMapping(path="/getALLrequst")
	public List<Request> getallRequstlist(){
		List<Request> get = rd.findAllRequests();
		return get;
		
	}
	
	@PostMapping(path="/adminApproveprocess")
	public ResponseEntity<Response> adminApproveprocess(@RequestBody Request re) {
		    Response rp = new Response();
		 
		    //check availability of book by using book table and history table
		   
		   
		     
		    //if available then do this
		    
		    
		    //else do this
		    

			rp.setPassmsg("your requst is cancelled");
			rp.setStatus(false);
			return new ResponseEntity<Response>(rp, HttpStatus.OK);
		    
		   
	}
	
	@PostMapping(path="/Quntityvalidation")
	public String Quntityvalidation(@RequestBody Request re) {
		HistoryCountModel hcm = new HistoryCountModel();
		hcm.setBook_id(re.getBookid());
		hcm.setStart_date(re.getStartdate());
		hcm.setEnd_date(re.getEnddate());
		HistoryCountReturn s = rd.gettotalBookQuantity(hcm);
		Book bk = bdi.findById(re.getBookid());
		
		if(bk.getQuantity() > s.getCount()) {
			int actual = bk.getQuantity()-s.getCount();
			if(re.getBookquantity()<=actual) {
//				int h =
				his.addHistory(re);
				return "Available";
			}else {
				return "Not Available";
			}
		}else {
			return "Not Available";
		}
		
		
	}
	
	

}
