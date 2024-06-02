package com.management.library.model;

import java.util.Objects;

public class Admin {
    private int adminid;
    private String name;
    private String employeeid;
    private String department;
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public int hashCode() {
		return Objects.hash(adminid, department, employeeid, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(adminid, other.adminid) && Objects.equals(department, other.department)
				&& Objects.equals(employeeid, other.employeeid) && Objects.equals(name, other.name);
	}
	public Admin(int adminid, String name, String employeeid, String department) {
		super();
		this.adminid = adminid;
		this.name = name;
		this.employeeid = employeeid;
		this.department = department;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", name=" + name + ", employeeid=" + employeeid + ", department="
				+ department + "]";
	}

    
}
