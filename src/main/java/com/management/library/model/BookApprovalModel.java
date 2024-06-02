package com.management.library.model;

import java.util.Objects;

public class BookApprovalModel {
	
	private int requestid;
	private boolean approved;
	public int getRequestid() {
		return requestid;
	}
	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	@Override
	public int hashCode() {
		return Objects.hash(approved, requestid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookApprovalModel other = (BookApprovalModel) obj;
		return approved == other.approved && requestid == other.requestid;
	}
	@Override
	public String toString() {
		return "BookApprovalModel [requestid=" + requestid + ", approved=" + approved + "]";
	}
	
	
	

}
