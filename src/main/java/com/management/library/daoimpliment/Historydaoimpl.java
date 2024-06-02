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

import com.management.library.dao.Historydao;
import com.management.library.model.BookIdViewModel;
import com.management.library.model.BookidDetails;
import com.management.library.model.History;
import com.management.library.model.Request;

@Repository
public class Historydaoimpl implements Historydao{
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public List<History> getAllHistory() {
		Connection con =null;
		PreparedStatement ps= null;
		String sql ="";
		ResultSet rs =null;
		List<History> lh = new ArrayList<>();
		History h = new History();
		try {
			con = dataSource.getConnection();
			sql= "select historyid,studentid,bookid,startdate,enddate,bookquantity from history";
			ps= con.prepareStatement(sql);
			rs =ps.executeQuery();
			
			while(rs.next()) {
				h = new History(
						rs.getInt("historyid"),
						rs.getInt("studentid"),
						rs.getInt("bookid"),
						rs.getString("startdate"),
						rs.getString("enddate"),
						rs.getInt("bookquantity")
						);
				lh.add(h);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return lh;
	}

	@Override
	public int addHistory(Request h) {
		Connection con = null;
		PreparedStatement ps =null;
		String sql = "";
		int i =0;
		try {
			con = dataSource.getConnection();
			sql ="insert into history (studentid,bookid,startdate,enddate,bookquantity) values (?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, h.getStudentid());
			ps.setInt(2, h.getBookid());
			ps.setString(3, h.getStartdate());
			ps.setString(4, h.getEnddate());
			ps.setInt(5, h.getBookquantity());
			i = ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) {
					con.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}

	@Override
	public int getBookfromhistorybyid(int bookid) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="";
		ResultSet rs=null;
		int i =0;
		try {
			con=dataSource.getConnection();
			sql="select sum(bookquantity)  as Bookquantity from history where bookid =?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bookid);
			rs=ps.executeQuery();
			
			if(rs.next()) {
			i = rs.getInt("Bookquantity");
			}else {
				i =0;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con != null) {
					con.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return i;
	}

	@Override
	public BookidDetails getDetailbyBookid(int bookid) {
		
		Connection con =null;
		PreparedStatement ps = null;
		String sql = "";
		BookidDetails r=new BookidDetails();
		ResultSet rs= null;
		
		BookIdViewModel bm ;
		List<BookIdViewModel>tt=new ArrayList<>();
		int i =0;
		try {
			con = dataSource.getConnection();
			sql = "select studentid,bookid,startdate,enddate,bookquantity from history where bookid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bookid);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				bm = new BookIdViewModel(
						rs.getInt("studentid"),
						rs.getInt("bookid"),
						rs.getString("startdate"),
						rs.getString("enddate"),
						rs.getInt("bookquantity")
						);
				i=i+rs.getInt("bookquantity");
				tt.add(bm);
			}
			 r=new BookidDetails(i,tt);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return r;
		
	}
	
}
