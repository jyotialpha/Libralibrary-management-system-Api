package com.management.library.daoimpliment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.management.library.dao.Studentdao;
import com.management.library.model.Student;

@Repository
public class Studentdaoimp implements Studentdao{
	@Autowired
	DataSource dataSource;

	@Override
	public int save(Student student) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		int i = 0;
		try {
			con =dataSource.getConnection();
			sql= "Insert into student (studentid,studentname,rollno,phonenumber,address) values(?,?,?,?,?)";
			ps= con.prepareStatement(sql);
			
			ps.setLong(1, student.getStudentid());
			ps.setString(2, student.getStudentname());
			ps.setString(3, student.getRollno());
			ps.setString(4, student.getPhonenumber());
			ps.setString(5, student.getAddress());
			
			i =ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return i;
	}

	@Override
	public Student findById(Long studentid) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		ResultSet rs = null;
		Student s = new Student();
		try {
			con = dataSource.getConnection();
			sql ="select studentid,studentname,rollno,phonenumber,address from student where studentid=?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, studentid);
			
			rs =ps.executeQuery();
			
			if(rs.next()) {
				s= new Student(
						rs.getLong("studentid"),
						rs.getString("studentname"),
						rs.getString("rollno"),
						rs.getString("phonenumber"),
						rs.getString("address")
						);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public int update(Student student) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "";
		int i =0;
		try {
			con = dataSource.getConnection();
			sql="update student set studentname=?,rollno=?,phonenumber=?,address=? where studentid=? ";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, student.getStudentname());
			ps.setString(2, student.getRollno());
			ps.setString(3, student.getPhonenumber());
			ps.setString(4, student.getAddress());
			ps.setLong(5, student.getStudentid());
			
			i = ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int delete(Long studentid) {
		Connection con = null;
		PreparedStatement ps =null;
		String sql ="";
		int i =0;
		try {
			con =dataSource.getConnection();
			sql = "delete from student where studentid=?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, studentid);
			
			i= ps.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try{
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
				}
		}
		return i;
	}
		

}
