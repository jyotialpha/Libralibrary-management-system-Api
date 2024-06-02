package com.management.library.model;

import java.util.Objects;

public class Student {
	    private Long studentid;
	    private String studentname;
	    private String rollno;
	    private String phonenumber;
	    private String address;
		public Long getStudentid() {
			return studentid;
		}
		public void setStudentid(Long studentid) {
			this.studentid = studentid;
		}
		public String getStudentname() {
			return studentname;
		}
		public void setStudentname(String studentname) {
			this.studentname = studentname;
		}
		public String getRollno() {
			return rollno;
		}
		public void setRollno(String rollno) {
			this.rollno = rollno;
		}
		public String getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		@Override
		public int hashCode() {
			return Objects.hash(address, phonenumber, rollno, studentid, studentname);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			return Objects.equals(address, other.address) && Objects.equals(phonenumber, other.phonenumber)
					&& Objects.equals(rollno, other.rollno) && Objects.equals(studentid, other.studentid)
					&& Objects.equals(studentname, other.studentname);
		}
		public Student(Long studentid, String studentname, String rollno, String phonenumber, String address) {
			super();
			this.studentid = studentid;
			this.studentname = studentname;
			this.rollno = rollno;
			this.phonenumber = phonenumber;
			this.address = address;
		}
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Student [studentid=" + studentid + ", studentname=" + studentname + ", rollno=" + rollno
					+ ", phonenumber=" + phonenumber + ", address=" + address + "]";
		}

	   

}
