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

import com.management.library.dao.Bookdao;
import com.management.library.model.Book;

@Repository
public class BookDAOImp implements 	Bookdao{
	
	@Autowired
	DataSource dataSource;

	@Override
	public int save(Book book) {
		Connection con =null;
		PreparedStatement ps = null;
		int i =0;
		String sql = "";
		
		try {
			con = dataSource.getConnection();
			sql = "insert into Book (bookid,bookname,author,page,quantity) values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setLong(1, book.getBookid());
			ps.setString(2, book.getBookname());
			ps.setString(3, book.getAuthor());
			ps.setInt(4, book.getPage());
			ps.setInt(5, book.getQuantity());
			
			
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
	public Book findById(int bookid) {
		Connection con =null;
		PreparedStatement ps = null;
		String sql = "";
		ResultSet rs= null;
		Book b =  new Book();
		try {
			con = dataSource.getConnection();
			sql = "select bookid,bookname,author,page,quantity from book where bookid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bookid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				b = new Book(
						rs.getInt("bookid"),
						rs.getString("bookname"),
						rs.getString("author"),
						rs.getInt("page"),
						rs.getInt("quantity")
						);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Book> findAll() {
		Connection con =null;
		PreparedStatement ps = null;
		String sql = "";
		ResultSet rs =null;
		List<Book> ls = new ArrayList<>();
		Book b = new Book();
		try {
			con = dataSource.getConnection();
			sql = "select bookid,bookname,author,page,quantity from book";
			ps = con.prepareStatement(sql);
			rs =ps.executeQuery();
			
			while(rs.next()) {
				b=new Book(
						rs.getInt("bookid"),
						rs.getString("bookname"),
						rs.getString("author"),
						rs.getInt("page"),
						rs.getInt("quantity")
						);
				ls.add(b);
			}
			
			
			
		}catch(Exception e){
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
		
		return ls;
	}

	
	
	@Override
	public int update(Book book) {
		Connection con = null;
		PreparedStatement ps =null;
		String sql ="";
		int i =0;
		try {
			con =dataSource.getConnection();
			sql = "update book set bookname=?,author=?,page=?,quantity=? where bookid=? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, book.getBookname());
			ps.setString(2, book.getAuthor());
			ps.setInt(3, book.getPage());
			ps.setInt(4, book.getQuantity());
			ps.setLong(5, book.getBookid());
			
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
	public int delete(Long bookId) {
		Connection con = null;
		PreparedStatement ps =null;
		String sql ="";
		int i =0;
		try {
			con =dataSource.getConnection();
			sql = "delete from book where bookid=?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, bookId);
			
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
