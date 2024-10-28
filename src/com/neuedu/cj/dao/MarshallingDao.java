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
import com.neuedu.cj.model.Marshalling;
import com.neuedu.cj.util.DbConnection;

public class MarshallingDao {
	 
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	public boolean insert(Marshalling marshalling){
		Connection conn=new DbConnection().getConnection();
		  String sql="insert into tb_marshalling values(null,?,?,?,?,?)";
			try {
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setObject(1,marshalling.getTrafficCode());
				pst.setObject(2,marshalling.getCarriageNumber());
				pst.setObject(3,marshalling.getCarSeatType());
				pst.setObject(4,marshalling.getCarSeatNumber());
				pst.setObject(5,marshalling.getCarType());
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
	
	public List<Marshalling> findAll(){
		List<Marshalling> marshallingList=new ArrayList<Marshalling>();		
		Connection conn=new DbConnection().getConnection();
		  String sql="select * from tb_marshalling";
			try {
				PreparedStatement pst=conn.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();
				while(rs.next()){
					Marshalling marshalling=new Marshalling();
					marshalling.setTrainMarshallingNumber(rs.getInt(1));
					marshalling.setTrafficCode(rs.getString(2));
					marshalling.setCarriageNumber(rs.getString(3));
					marshalling.setCarSeatType(rs.getString(4));
					marshalling.setCarSeatNumber(rs.getString(5));
					marshalling.setCarType(rs.getString(6));
					marshallingList.add(marshalling);
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
		return marshallingList;
	}
	
	public List<Marshalling> findMarshallingsByDynamic (Marshalling mar){
		

		List<Marshalling> marshallingList=new ArrayList<Marshalling>();
		Connection conn=new DbConnection().getConnection();
		  String sql="select * from tb_marshalling where 1=1";
		  StringBuilder sb=new StringBuilder(sql);
		  if(mar.getTrafficCode()!=null&& !"".equals(mar.getTrafficCode())){
			 sb.append(" and TrafficCode like '%"+mar.getTrafficCode()+"%'") ;  
		  }
		  if(mar.getCarriageNumber()!=null && !"".equals(mar.getCarriageNumber())){
			  sb.append(" and CarriageNumber='"+mar.getCarriageNumber()+"'") ;
		  }
		  if(mar.getCarSeatType()!=null && !"".equals(mar.getCarSeatType())){
			  sb.append(" and CarSeatType='"+mar.getCarSeatType()+"'") ;
		  } 
		  
		  if(mar.getCarSeatNumber()!=null && !"".equals(mar.getCarSeatNumber())){
			  sb.append(" and CarSeatNumber='"+mar.getCarSeatNumber()+"'") ;
		  }
		  
		  if(mar.getCarType()!=null && !"".equals(mar.getCarType())){
			  sb.append(" and CarType='"+mar.getCarType()+"'") ;
			  
		  }
		  
			try {
				Statement pst=conn.createStatement();
				ResultSet rs=pst.executeQuery(sb.toString());
				while(rs.next()){
					Marshalling marshalling=new Marshalling();
					marshalling.setTrainMarshallingNumber(rs.getInt(1));
					marshalling.setTrafficCode(rs.getString(2));
					marshalling.setCarriageNumber(rs.getString(3));
					marshalling.setCarSeatType(rs.getString(4));
					marshalling.setCarSeatNumber(rs.getString(5));
					marshalling.setCarType(rs.getString(6));
					marshallingList.add(marshalling);
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
		return marshallingList;
	}
	
	public Marshalling findmarshallingsBytId (Marshalling marshalling){
		
		Connection conn=new DbConnection().getConnection();
		  String sql="select * from tb_marshalling where TrainMarshallingNumber=?";
			try {
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setObject(1,marshalling.getTrainMarshallingNumber());
				ResultSet rs=pst.executeQuery();
				rs.next();
				marshalling.setTrainMarshallingNumber(rs.getInt(1));
				marshalling.setTrafficCode(rs.getString(2));
				marshalling.setCarriageNumber(rs.getString(3));
				marshalling.setCarSeatType(rs.getString(4));
				marshalling.setCarSeatNumber(rs.getString(5));
				marshalling.setCarType(rs.getString(6));
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
		return marshalling;
	}
	
	
	public boolean update(Marshalling marshalling){
		Connection conn=new DbConnection().getConnection();
		  String sql="update tb_marshalling set TrafficCode=?,CarriageNumber=?,CarSeatType=?,CarSeatNumber=?,CarType=? where TrainMarshallingNumber=?";
			try {
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setObject(1,marshalling.getTrafficCode());
				pst.setObject(2,marshalling.getCarriageNumber());
				pst.setObject(3,marshalling.getCarSeatType());
				pst.setObject(4,marshalling.getCarSeatNumber());
				pst.setObject(5,marshalling.getCarType());
				pst.setObject(6,marshalling.getTrainMarshallingNumber());
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
		  String sql="delete from tb_marshalling where TrainMarshallingNumber=?";
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


