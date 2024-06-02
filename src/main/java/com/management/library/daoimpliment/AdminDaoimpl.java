package com.management.library.daoimpliment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.management.library.dao.Admindao;
import com.management.library.model.Admin;
@Repository
public class AdminDaoimpl implements Admindao{
	
	@Autowired
	DataSource dataSource;

	@Override
	public int save(Admin admin) {
		Connection con =null;
		PreparedStatement ps = null;
		int i =0;
		String sql = "";
		
		try {
			con = dataSource.getConnection();
			sql = "insert into admin (adminid,name,employeeid,department) values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setLong(1, admin.getAdminid());
			ps.setString(2, admin.getName());
			ps.setString(3, admin.getEmployeeid());
			ps.setString(4, admin.getDepartment());
			
			
			
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
	public List<Admin> findAll() {
		Connection con =null;
		PreparedStatement ps =null;
		String sql ="";
		ResultSet rs = null;
		List<Admin> ls = new ArrayList<>();
		Admin ad = new Admin();
		try {
			con = dataSource.getConnection();
			sql ="select adminid,name,employeeid,department from admin ";
			ps = con.prepareStatement(sql);
			
			rs =ps.executeQuery();
			
			while(rs.next()) {
				ad = new Admin(
						rs.getInt("adminid"),
						rs.getString("name"),
						rs.getString("employeeid"),
						rs.getString("department")
						);
						ls.add(ad);
			}
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
		return ls;
	}

	@Override
	public int update(Admin admin) {
		Connection con =null;
		PreparedStatement ps =null;
		String sql ="";
		int i =0;
		try {
			con = dataSource.getConnection();
			sql = "update admin set name=?,employeeid=?,department=? where adminid=?";
			ps= con.prepareStatement(sql);
			
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getEmployeeid());
			ps.setString(3, admin.getDepartment());
			ps.setLong(4, admin.getAdminid());
			
			
			i = ps.executeUpdate();
			
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

	@Override
	public int delete(Long adminid) {
		Connection con =null;
		PreparedStatement ps =null;
		String sql ="";
		int i =0;
		try {
			con = dataSource.getConnection();
			sql = "delete from admin where adminid=?";
			ps= con.prepareStatement(sql);
			
			ps.setLong(1, adminid);
			
			
			i = ps.executeUpdate();
			
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
