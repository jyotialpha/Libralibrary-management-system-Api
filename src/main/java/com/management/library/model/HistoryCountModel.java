package com.management.library.model;

import java.util.Objects;

public class HistoryCountModel {
	
	private int book_id;
	private String start_date;
	private String end_date;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	@Override
	public int hashCode() {
		return Objects.hash(book_id, end_date, start_date);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoryCountModel other = (HistoryCountModel) obj;
		return book_id == other.book_id && Objects.equals(end_date, other.end_date)
				&& Objects.equals(start_date, other.start_date);
	}
	@Override
	public String toString() {
		return "HistoryCountModel [book_id=" + book_id + ", start_date=" + start_date + ", end_date=" + end_date + "]";
	}
	
	

}
