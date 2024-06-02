package com.management.library.model;

import java.util.Objects;

public class History {
	 private int historyid;
	    private int studentid;
	    private int bookid;
	    private String startdate;
	    private String enddate;
	    private int bookquantity;
		public int getHistoryid() {
			return historyid;
		}
		public void setHistoryid(int historyid) {
			this.historyid = historyid;
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
		@Override
		public int hashCode() {
			return Objects.hash( bookid, bookquantity, enddate, historyid, startdate, studentid);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			History other = (History) obj;
			return Objects.equals(bookid, other.bookid)
					&& bookquantity == other.bookquantity && Objects.equals(enddate, other.enddate)
					&& Objects.equals(historyid, other.historyid) && Objects.equals(startdate, other.startdate)
					&& Objects.equals(studentid, other.studentid);
		}
		public History(int historyid, int studentid, int bookid, String startdate, String enddate, int bookquantity) {
			super();
			this.historyid = historyid;
			this.studentid = studentid;
			this.bookid = bookid;
			this.startdate = startdate;
			this.enddate = enddate;
			this.bookquantity = bookquantity;
		}
		public History() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "History [historyid=" + historyid + ", studentid=" + studentid + ", bookid=" + bookid
					+ ", startdate=" + startdate + ", enddate=" + enddate + ", bookquantity=" + bookquantity
					 + "]";
		}


}
