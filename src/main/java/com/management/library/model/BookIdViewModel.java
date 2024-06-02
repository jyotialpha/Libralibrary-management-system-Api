package com.management.library.model;

import java.util.Objects;

public class BookIdViewModel {
	private int studentid;
	private int bookid;
	private String startdate;
	private String enddate;
	private int bookquantity;
	public BookIdViewModel(int studentid, int bookid, String startdate, String enddate, int bookquantity) {
		super();
		this.studentid = studentid;
		this.bookid = bookid;
		this.startdate = startdate;
		this.enddate = enddate;
		this.bookquantity = bookquantity;
	}
	public BookIdViewModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookid, bookquantity, enddate, startdate, studentid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookIdViewModel other = (BookIdViewModel) obj;
		return bookid == other.bookid && bookquantity == other.bookquantity && Objects.equals(enddate, other.enddate)
				&& Objects.equals(startdate, other.startdate) && studentid == other.studentid;
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
	
}
