package com.management.library.model;

import java.util.List;
import java.util.Objects;

public class BookidDetails {

	private int sumOfBookQuantity;
    private List<BookIdViewModel> bookDetails;
	public int getSumOfBookQuantity() {
		return sumOfBookQuantity;
	}
	public void setSumOfBookQuantity(int sumOfBookQuantity) {
		this.sumOfBookQuantity = sumOfBookQuantity;
	}
	public List<BookIdViewModel> getBookDetails() {
		return bookDetails;
	}
	public void setBookDetails(List<BookIdViewModel> bookDetails) {
		this.bookDetails = bookDetails;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookDetails, sumOfBookQuantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookidDetails other = (BookidDetails) obj;
		return Objects.equals(bookDetails, other.bookDetails) && sumOfBookQuantity == other.sumOfBookQuantity;
	}
	public BookidDetails(int sumOfBookQuantity, List<BookIdViewModel> bookDetails) {
		super();
		this.sumOfBookQuantity = sumOfBookQuantity;
		this.bookDetails = bookDetails;
	}
	public BookidDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookidDetails [sumOfBookQuantity=" + sumOfBookQuantity + ", bookDetails=" + bookDetails + "]";
	}
    
}
