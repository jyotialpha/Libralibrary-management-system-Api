package com.management.library.model;

import java.util.Objects;

public class HistoryCountReturn {

	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(count);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoryCountReturn other = (HistoryCountReturn) obj;
		return count == other.count;
	}

	@Override
	public String toString() {
		return "HistoryCountReturn [count=" + count + "]";
	}

	public HistoryCountReturn(int count) {
		super();
		this.count = count;
	}

	public HistoryCountReturn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
