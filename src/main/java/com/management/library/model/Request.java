package com.management.library.model;


import java.util.Date;
import java.util.Objects;

public class Request {
    private int requestid;
    private int studentid;
    private int bookid;
    private String startdate;
    private String enddate;
    private int bookquantity;
    private boolean approved;
	public int getRequestid() {
		return requestid;
	}
	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public int getBookquantity() {
		return bookquantity;
	}
	public void setBookquantity(int bookquantity) {
		this.bookquantity = bookquantity;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	@Override
	public int hashCode() {
		return Objects.hash(approved, bookid, bookquantity, enddate, requestid, startdate, studentid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		return approved == other.approved && bookid == other.bookid && bookquantity == other.bookquantity
				&& Objects.equals(enddate, other.enddate) && requestid == other.requestid
				&& Objects.equals(startdate, other.startdate) && studentid == other.studentid;
	}
	@Override
	public String toString() {
		return "Request [requestid=" + requestid + ", studentid=" + studentid + ", bookid=" + bookid + ", startdate="
				+ startdate + ", enddate=" + enddate + ", bookquantity=" + bookquantity + ", approved=" + approved
				+ "]";
	}
	public Request(int requestid, int studentid, int bookid, String startdate, String enddate, int bookquantity,
			boolean approved) {
		super();
		this.requestid = requestid;
		this.studentid = studentid;
		this.bookid = bookid;
		this.startdate = startdate;
		this.enddate = enddate;
		this.bookquantity = bookquantity;
		this.approved = approved;
	}
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
