package com.neuedu.cj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.cj.model.Manager;
import com.neuedu.cj.model.User;
import com.neuedu.cj.model.Train;
import com.neuedu.cj.model.Line;
import com.neuedu.cj.util.DbConnection;

public class LineDao {
	 
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	public boolean insert(Line line){
		Connection conn=new DbConnection().getConnection();
		  String sql="insert into tb_line values(null,?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setObject(1,line.getTrafficCode());
				pst.setObject(2,line.getStationName());
				pst.setObject(3,line.getDepartureTime());
				pst.setObject(4,line.getArrivalTime());
				pst.setObject(5,line.getMileage());
				pst.setObject(6,line.getResidenceTime());
				pst.setObject(7,line.getSpendTime());
				pst.setObject(8,line.getStationCode());
				int rowCount=pst.executeUpdate();
			    if(rowCount>0){
			    	return true;
			    	
			    }
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return false;
	}
	
	public List<Line> findAll(){
		List<Line> lineList=new ArrayList<Line>();		
		Connection conn=new DbConnection().getConnection();
		  String sql="select * from tb_line";
			try {
				PreparedStatement pst=conn.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();
				while(rs.next()){
					Line line=new Line();
					line.setLineNumber(rs.getInt(1));
					line.setTrafficCode(rs.getString(2));
					line.setStationName(rs.getString(3));
					line.setDepartureTime(rs.getDate(4));
					line.setArrivalTime(rs.getDate(5));
					line.setMileage(rs.getString(6));
					line.setResidenceTime(rs.getString(7));
					line.setSpendTime(rs.getString(8));
					line.setStationCode(rs.getString(9));

					lineList.add(line);
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return lineList;
	}
	
	public List<Line> findlinesByDynamic (Line lin){
		

		List<Line> lineList=new ArrayList<Line>();
		Connection conn=new DbConnection().getConnection();
		  String sql="select * from tb_line where 1=1";
		  StringBuilder sb=new StringBuilder(sql);
		  if(lin.getTrafficCode()!=null&& !"".equals(lin.getTrafficCode())){
			 sb.append(" and TrafficCode like '%"+lin.getTrafficCode()+"%'") ;  
		  }
		  if(lin.getStationName()!=null && !"".equals(lin.getStationName())){
			  sb.append(" and StationName='"+lin.getStationName()+"'") ;
		  }
		  if(lin.getStationCode()!=null && !"".equals(lin.getStationCode())){
			  sb.append(" and StationCode='"+lin.getStationCode()+"'") ;
		  } 
		  

		  
			try {
				Statement pst=conn.createStatement();
				ResultSet rs=pst.executeQuery(sb.toString());
				while(rs.next()){
					Line line=new Line();
					line.setLineNumber(rs.getInt(1));
					line.setTrafficCode(rs.getString(2));
					line.setStationName(rs.getString(3));
					line.setDepartureTime(rs.getDate(4));
					line.setArrivalTime(rs.getDate(5));
					line.setMileage(rs.getString(6));
					line.setResidenceTime(rs.getString(7));
					line.setSpendTime(rs.getString(8));
					line.setStationCode(rs.getString(9));

					lineList.add(line);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return lineList;
	}
	
	public Line findlinesBytId (Line line){
			
		Connection conn=new DbConnection().getConnection();
		  String sql="select * from tb_line where LineNumber=?";
			try {
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setObject(1,line.getLineNumber());
				ResultSet rs=pst.executeQuery();
				rs.next();
				line.setLineNumber(rs.getInt(1));
				line.setTrafficCode(rs.getString(2));
				line.setStationName(rs.getString(3));
				line.setDepartureTime(rs.getDate(4));
				line.setArrivalTime(rs.getDate(5));
				line.setMileage(rs.getString(6));
				line.setResidenceTime(rs.getString(7));
				line.setSpendTime(rs.getString(8));
				line.setStationCode(rs.getString(9));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return line;
	}
	
	
	
	public boolean update(Line line){
		Connection conn=new DbConnection().getConnection();
		  String sql="update tb_line set TrafficCode=?,StationName=?,DepartureTime=?,ArrivalTime=?,Mileage=?,ResidenceTime=?,SpendTime=?,StationCode=? where LineNumber=?";
			try {
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setObject(1,line.getTrafficCode());
				pst.setObject(2,line.getStationName());
				pst.setObject(3,line.getDepartureTime());
				pst.setObject(4,line.getArrivalTime());
				pst.setObject(5,line.getMileage());
				pst.setObject(6,line.getResidenceTime());
				pst.setObject(7,line.getSpendTime());
				pst.setObject(8,line.getStationCode());
				pst.setObject(9,line.getLineNumber());
				System.out.println("!"+pst+"!");
				int rowCount=pst.executeUpdate();
			    if(rowCount>0){
			    	return true;
			    	
			    }
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return false;
	}
	
	public boolean delete(int tid[]){
		Connection conn=new DbConnection().getConnection();
		  String sql="delete from tb_line where lineNumber=?";
			try {

				conn.setAutoCommit(false);
				PreparedStatement pst=conn.prepareStatement(sql);
				for (int i = 0; i < tid.length; i++) {
					pst.setInt(1, tid[i]);
					pst.addBatch();
				}
				
				int rowCount[]=pst.executeBatch();
				conn.commit();
			    if(rowCount.length>0){
			    	return true;
			    	
			    }
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return false;
	}
	

}


