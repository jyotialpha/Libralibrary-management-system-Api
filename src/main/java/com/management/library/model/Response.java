package com.management.library.model;

import java.util.Objects;

public class Response {
	private String passmsg;
	private boolean status;
	public String getPassmsg() {
		return passmsg;
	}
	public void setPassmsg(String passmsg) {
		this.passmsg = passmsg;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(passmsg, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		return Objects.equals(passmsg, other.passmsg) && status == other.status;
	}
	@Override
	public String toString() {
		return "Response [passmsg=" + passmsg + ", status=" + status + "]";
	}

}
