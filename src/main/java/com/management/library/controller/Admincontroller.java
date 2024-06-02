package com.management.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.management.library.daoimpliment.AdminDaoimpl;
import com.management.library.model.Admin;
import com.management.library.model.Response;

@RestController
public class Admincontroller {
	
	@Autowired
	AdminDaoimpl ad;
	
	
	@PostMapping(path="/Addadmindetails")
	public Response addBookstoLib(@RequestBody Admin admin) {
		
	Response rs =new Response();	
	
	if(admin.getAdminid()==0 ||admin.getName().equalsIgnoreCase("")||admin.getEmployeeid().equalsIgnoreCase("")|| admin.getDepartment().equalsIgnoreCase("")) {
		rs.setPassmsg("please fill null data");
		rs.setStatus(true);
		return rs;
	}
		int   add = ad.save(admin);
		if(add==0) {
			rs.setPassmsg("data is not added");
			rs.setStatus(false);
			return rs;
		}
		rs.setPassmsg("Data added Successfully");
		rs.setStatus(true);
		return  rs;
		
	}
	
	@GetMapping(path="/getAdmindetails")
	public List<Admin> getdetailsofAdmin(){
		List<Admin>  l = ad.findAll();
		return l;
		
	}
	
	@PostMapping(path="/updateAdmindetails")
	public Response updateAdmindata(@RequestBody Admin admin) {
		Response rs = new Response();
		if(admin.getDepartment().equalsIgnoreCase("")||admin.getEmployeeid().equalsIgnoreCase("")) {
		
			rs.setPassmsg("null value at department or employeeid");
			rs.setStatus(true);
			return rs;
		}
		
		int up = ad.update(admin);
		if(up==0) {
			rs.setPassmsg("Data is not updated");
			rs.setStatus(false);
			return rs;
		}
		rs.setPassmsg("Data updated successfully");
		rs.setStatus(true);
		return rs;
	}
	
	
	@DeleteMapping(path="/deleteByadminid/{adminid}")
	public Response deleteAdmindetialsbyID(@PathVariable("adminid") Long adminid) {
		Response rs = new Response();
		
		if(adminid ==0) {
			rs.setPassmsg("plz enter Adminid");
			rs.setStatus(true);
			return rs;
		}
		int d = ad.delete(adminid);
		if(d==0) {
			rs.setPassmsg("data is not deleted");
			rs.setStatus(false);
			return rs;
		}
		rs.setPassmsg("data deleted Successfully");
		rs.setStatus(true);
		return rs;
		
	}
	
	
}
