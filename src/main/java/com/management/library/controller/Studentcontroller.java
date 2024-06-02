package com.management.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.management.library.daoimpliment.Studentdaoimp;
import com.management.library.model.Response;
import com.management.library.model.Student;

@RestController
public class Studentcontroller {
	@Autowired
	Studentdaoimp s;
	
	 @PutMapping(path="/getStudentbyID/{studentid}")
	    public Student getStudentdetails(@PathVariable("studentid") Long studentid) {
	  
	    	Student st = s.findById(studentid);
			return st;
	    }

	
	@PostMapping(path="/AddStudent")
	public Response addStudent(@RequestBody Student student) {
		
	Response rs =new Response();	
	
	if(student.getStudentname().equalsIgnoreCase("") || student.getAddress().equalsIgnoreCase("")||student.getRollno().equalsIgnoreCase("")) {
		rs.setPassmsg("please fill your details..");
		rs.setStatus(true);
		return rs;
	};
		int   add = s.save(student);
		if(add==0) {
			rs.setPassmsg("data is not added");
			rs.setStatus(false);
			return rs;
		}
		rs.setPassmsg("Data added Successfully");
		rs.setStatus(true);
		return  rs;
		
	}

    @PostMapping(path="/updateStudentdata")
	public Response updateBook(@RequestBody Student student) {
		Response rs = new Response();
		if(student.getAddress().equalsIgnoreCase("")) {
			rs.setPassmsg("NUll value");
			rs.setStatus(true);
			return rs;
		}
		int up = s.update(student);
		
		if(up == 0) {
			rs.setPassmsg("Data is not updated");
			rs.setStatus(false);
			return rs;
		}
		rs.setPassmsg("Data updated success fully");
		rs.setStatus(true);
		return rs;
	}
	
    @DeleteMapping(path="/deleteStudentRecord/{studentid}")
    public Response deletebookRecord(@PathVariable("studentid") Long studentid) {
    	Response rs =  new Response();
    	
    	if(studentid==0) {
    		rs.setPassmsg("plz enter an bookid");
    		rs.setStatus(false);
    		return rs;
    	}
    		int delete = s.delete(studentid);
    		
    	if(delete==0) {
    		rs.setPassmsg("data is not deleted");
    		rs.setStatus(false);
    		return rs;
    	}	
    	rs.setPassmsg("data is deleted succesfully");
		rs.setStatus(true);
		return rs;
    }
    
       

}
