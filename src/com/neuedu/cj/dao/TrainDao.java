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
import com.neuedu.cj.util.DbConnection;

public class TrainDao {
	 
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	public boolean insert(Train train){
		Connection conn=new DbConnection().getConnection();
		  String sql="insert into tb_train values(null,?,?,?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setObject(1,train.getTraffic());
				pst.setObject(2,train.getDepartureStation());
				pst.setObject(3,train.getTerminalStation());
				pst.setObject(4,train.getStartingTime());
				pst.setObject(5,train.getEndTime());
				pst.setObject(6,train.getDuration());
				pst.setObject(7,train.getMileage());
				pst.setObject(8,train.getNoSeat());
				pst.setObject(9,train.getVehicleType());
				pst.setObject(10,train.getTrainType());
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
	
	public List<Train> findAll(){
		List<Train> trainList=new ArrayList<Train>();		
		Connection conn=new DbConnection().getConnection();
		  String sql="select * from tb_train";
			try {
				PreparedStatement pst=conn.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();
				while(rs.next()){
					Train train=new Train();
					train.settId(rs.getInt(1));
					train.setTraffic(rs.getString(2));
					train.setDepartureStation(rs.getString(3));
					train.setTerminalStation(rs.getString(4));
					train.setStartingTime(rs.getDate(5));
					train.setEndTime(rs.getDate(6));
					train.setDuration(rs.getString(7));
					train.setMileage(rs.getString(8));
					train.setNoSeat(rs.getString(9));
					train.setVehicleType(rs.getString(10));
					train.setTrainType(rs.getString(11));
					trainList.add(train);
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
		return trainList;
	}
	
	public List<Train> findtrainsByDynamic (Train tra){
		

		List<Train> trainList=new ArrayList<Train>();
		Connection conn=new DbConnection().getConnection();
		  String sql="select * from tb_train where 1=1";
		  StringBuilder sb=new StringBuilder(sql);
		  if(tra.getTraffic()!=null&& !"".equals(tra.getTraffic())){
			 sb.append(" and TrafficCode like '%"+tra.getTraffic()+"%'") ;  
		  }
		  if(tra.getDepartureStation()!=null && !"".equals(tra.getDepartureStation())){
			  sb.append(" and DepartureStation='"+tra.getDepartureStation()+"'") ;
		  }
		  if(tra.getTerminalStation()!=null && !"".equals(tra.getTerminalStation())){
			  sb.append(" and TerminalStation='"+tra.getTerminalStation()+"'") ;
		  } 
		  
		  if(tra.getVehicleType()!=null && !"".equals(tra.getVehicleType())){
			  sb.append(" and VehicleClassification='"+tra.getVehicleType()+"'") ;
		  }
		  
		  if(tra.getTrainType()!=null && !"".equals(tra.getTrainType())){
			  sb.append(" and TrainType='"+tra.getTrainType()+"'") ;
			  
		  }
		  
			try {
				Statement pst=conn.createStatement();
				ResultSet rs=pst.executeQuery(sb.toString());
				while(rs.next()){
					Train train=new Train();
					train.settId(rs.getInt(1));
					train.setTraffic(rs.getString(2));
					train.setDepartureStation(rs.getString(3));
					train.setTerminalStation(rs.getString(4));
					train.setStartingTime(rs.getDate(5));
					train.setEndTime(rs.getDate(6));
					train.setDuration(rs.getString(7));
					train.setMileage(rs.getString(8));
					train.setNoSeat(rs.getString(9));
					train.setVehicleType(rs.getString(10));
					train.setTrainType(rs.getString(11));
					trainList.add(train);
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
		return trainList;
	}
	
	public Train findtrainsBytId (Train train){
			
		Connection conn=new DbConnection().getConnection();
		  String sql="select * from tb_train where tId=?";
			try {
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setObject(1,train.gettId());
				ResultSet rs=pst.executeQuery();
				rs.next();
				train.settId(rs.getInt(1));
				train.setTraffic(rs.getString(2));
				train.setDepartureStation(rs.getString(3));
				train.setTerminalStation(rs.getString(4));
				train.setStartingTime(rs.getDate(5));
				train.setEndTime(rs.getDate(6));
				train.setDuration(rs.getString(7));
				train.setMileage(rs.getString(8));
				train.setNoSeat(rs.getString(9));
				train.setVehicleType(rs.getString(10));
				train.setTrainType(rs.getString(11));
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
		return train;
	}
	
	
	
	public boolean update(Train train){
		Connection conn=new DbConnection().getConnection();
		  String sql="update tb_train set TrafficCode=?,DepartureStation=?,TerminalStation=?,StartTime=?,EndTime=?,SpendTime=?,Mileage=?,NoticketNumber=?,VehicleClassification=?,TrainType=? where tId=?";
			try {
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setObject(1,train.getTraffic());
				pst.setObject(2,train.getDepartureStation());
				pst.setObject(3,train.getTerminalStation());
				pst.setObject(4,train.getStartingTime());
				pst.setObject(5,train.getEndTime());
				pst.setObject(6,train.getDuration());
				pst.setObject(7,train.getMileage());
				pst.setObject(8,train.getNoSeat());			
				pst.setObject(9,train.getVehicleType());
				pst.setObject(10,train.getTrainType());				
				pst.setObject(11,train.gettId());
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
		  String sql="delete from tb_train where tId=?";
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


