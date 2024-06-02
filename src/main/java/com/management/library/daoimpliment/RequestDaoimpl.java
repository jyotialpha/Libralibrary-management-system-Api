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

import com.management.library.dao.Requestdao;
import com.management.library.model.History;
import com.management.library.model.HistoryCountModel;
import com.management.library.model.HistoryCountReturn;
import com.management.library.model.Request;

@Repository
public class RequestDaoimpl implements Requestdao{
	@Autowired
	DataSource dataSource;
	@Autowired
	BookDAOImp reff;

	@Override
	public int add(Request requestEntity) {
		
		Connection con =null;
		PreparedStatement ps=null;
		String sql = "";
		int i =0;
		
		try {
			con = dataSource.getConnection();
			sql ="insert into requestentity (requestid,studentid,bookid,startdate,enddate,bookquantity) values(?,?,?,?,?,?)";
			ps= con.prepareStatement(sql);
			
			ps.setInt(1,requestEntity.getRequestid() );
			ps.setInt(2, requestEntity.getStudentid());
			ps.setInt(3, requestEntity.getBookid());
			ps.setString(4, requestEntity.getStartdate());
			ps.setString(5, requestEntity.getEnddate());
			ps.setInt(6, requestEntity.getBookquantity());
			
			i = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(con != null){
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
	public List<Request> findAllRequests() {
		Connection con  =null;
		PreparedStatement ps =null;
		String sql ="";
		ResultSet rs= null;
		List<Request>  requstlist = new ArrayList<>();
		Request rq = new Request();
		try {
			con = dataSource.getConnection();
			sql =" select requestid,studentid,bookid,startdate,enddate,bookquantity from requestentity ";
			ps =con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				rq = new Request(
						rs.getInt("requestid"),
						rs.getInt("studentid"),
						rs.getInt("bookid"),
						rs.getString("startdate"),
						rs.getString("enddate"),
						rs.getInt("bookquantity"),
						rs.getBoolean("approved") 
						);
				requstlist.add(rq);
			}
		}catch(SQLException e) {
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
		return requstlist;
	}

	@Override
	public List<History> findAllHistory() {
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
/*
	@Override
	public int updateApprovalStatus(int requestId, boolean approved) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    String sql = "";
	    try {
//	        con = dataSource.getConnection();
//	        updateApproval( requestId, approved);
	        if(approved == true) {
	        	
	        	//moveRequestToHistory(requestId);
	        	//deleteRequestInTransaction(requestId);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return 0;
	}

	private int updateApproval(int requestId, boolean approved) {
		Connection con = null;
	    PreparedStatement ps = null;
	    String sql = "";
	    int i =0;
		
		try {
	    	con = dataSource.getConnection();
	    	sql = "UPDATE requestentity SET approved = ? WHERE requestid = ?";
	    	ps = con.prepareStatement(sql);
	    	ps.setLong(1,requestId );
	    	ps.setBoolean(2, approved);
	    	
	    	i =ps.executeUpdate();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		return i;
	}
	 
	public int moveRequestToHistory( int requestId){
		Connection con = null;
	    PreparedStatement ps = null;
	    String sql = "";
	    int i =0;
	    Request request = new Request(); //create the object for getting request entity
	    Admin ad = new Admin(); //create the object for getting adminid for approval record
	    try {
	    	con = dataSource.getConnection();
	    	sql = "INSERT INTO history (studentid, bookid, startdate, enddate, bookquantity, approvedby)VALUES (?, ?, ?, ?, ?, ?)";
	    	ps = con.prepareStatement(sql);
	    	
	    	ps.setInt(1, request.getStudentid());
	    	ps.setInt(2, request.getBookid());
	    	ps.setString(3, request.getStartdate());
	    	ps.setString(4, request.getEnddate());
	    	ps.setInt(5, request.getBookquantity());
	    	ps.setLong(6, ad.getAdminid());
	    	i =ps.executeUpdate();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		return i;
    }
	
	public int deleteRequestInTransaction(int requestId){
		Connection con = null;
	    PreparedStatement ps = null;
	    String sql = "";
	    int i =0;
	   //Request request = new Request();
	    try {
	    	con = dataSource.getConnection();
	    	sql= "DELETE FROM requestentity WHERE requestid = ?";
	    	ps = con.prepareStatement(sql);
	    	ps.setLong(1,  requestId);
	    	i = ps.executeUpdate();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return i;
	   
	}
	*/
/*
	@Override
	public String RequestforbookApproval( Request request) {
		
		List<Book> re =reff.findAll();
		RequestDaoimpl obj=new RequestDaoimpl();
		
		for(Book r : re) {
			if(r.getBookid()==request.getBookid()) {
				
				//int w=r.getQuantity()-request.getBookquantity();
					
				Connection con=null;
				
				PreparedStatement ps=null;
				String sql="";
				String sql2="";
				int w=0;
				try {
					con=dataSource.getConnection();
					sql="insert into history(studentid,bookid,startdate,enddate,bookquantity) values (?,?,?,?,?)";
					ps=con.prepareStatement(sql);
					ps.setInt(1, request.getStudentid());
					ps.setInt(2, request.getBookid());
					ps.setString(3, request.getStartdate());
					ps.setString(4, request.getEnddate());
					ps.setInt(5, request.getBookquantity());
					 w=ps.executeUpdate();	
					 
					return "Approve sucess";
					
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
		}
		}
		 
		return "Not Approved";
	}
	
	 */	
	//...

	@Override
	public  HistoryCountReturn gettotalBookQuantity(HistoryCountModel hcm) {
		Connection con=null;
		String sql="";
		PreparedStatement ps=null;
		ResultSet rs=null;
		HistoryCountReturn hcr = new HistoryCountReturn();
		try {
			con=dataSource.getConnection();
			sql =" SELECT case when SUM(bookquantity) is null then 0 else SUM(bookquantity) end AS totalBookQuantity FROM history WHERE history.bookid = ? and ( "
					+ " (? between history.startdate and history.enddate) or "
					+ " (? between history.startdate and history.enddate) or "
					+ " (? < history.startdate and ? > history.enddate) "
					+ " ) ";
			ps = con.prepareStatement(sql);
			ps.setInt(1, hcm.getBook_id());
			ps.setString(2, hcm.getStart_date());
			ps.setString(3, hcm.getEnd_date());
			ps.setString(4, hcm.getStart_date());
			ps.setString(5, hcm.getEnd_date());
		
			rs= ps.executeQuery();
			if(rs.next()) {
				hcr = new HistoryCountReturn(
					rs.getInt("totalBookQuantity")
			    );
			}
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
		return hcr;
	}

	
	
	
		
	
	
}

//.....................................................................
