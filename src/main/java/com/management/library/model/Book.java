package com.management.library.model;

import java.util.Objects;

public class Book {
	    private int bookid;
	    private String bookname;
	    private String author;
	    private int page;
	    private int quantity;
		public int getBookid() {
			return bookid;
		}
		public void setBookid(int bookid) {
			this.bookid = bookid;
		}
		public String getBookname() {
			return bookname;
		}
		public void setBookname(String bookname) {
			this.bookname = bookname;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public int getPage() {
			return page;
		}
		public void setPage(int page) {
			this.page = page;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		@Override
		public int hashCode() {
			return Objects.hash(author, bookid, bookname, page, quantity);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			return Objects.equals(author, other.author) && Objects.equals(bookid, other.bookid)
					&& Objects.equals(bookname, other.bookname) && page == other.page && quantity == other.quantity;
		}
		public Book(int bookid, String bookname, String author, int page, int quantity) {
			super();
			this.bookid = bookid;
			this.bookname = bookname;
			this.author = author;
			this.page = page;
			this.quantity = quantity;
		}
		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Book [bookid=" + bookid + ", bookname=" + bookname + ", author=" + author + ", page=" + page
					+ ", quantity=" + quantity + "]";
		}
	    

}
