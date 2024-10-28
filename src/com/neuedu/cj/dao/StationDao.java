package com.neuedu.cj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.cj.model.Station;
import com.neuedu.cj.util.DbConnection;

public class StationDao {
	 
	/**
	 * ��ӳ�վ��Ϣ
	 * @param station
	 * @return
	 */
	public boolean insert(Station station){
		
		Connection conn=new DbConnection().getConnection();
		  String sql="insert into tb_station values(null,?,?,?,?,?,?,?)";
			try {
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setObject(1,station.getStationCode());
				pst.setObject(2,station.getStationName());
				pst.setObject(3,station.getPinyinCode());
				pst.setObject(4,station.getRailwayBureau());
				pst.setObject(5,station.getStationGrade());
				pst.setObject(6,station.getAdministrativeRegion());
				pst.setObject(7,station.getContactAddress());
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

	
	
	/**
	 * @return
	 */
	public List<Station> findAll(){
		List<Station> stationList=new ArrayList<Station>();
		Connection conn=new DbConnection().getConnection();
		  String sql="select * from tb_station";
			try {
				PreparedStatement pst=conn.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();
				while(rs.next()){
					Station station=new Station();
					station.setsId(rs.getInt(1));
					station.setStationCode(rs.getString(2));
					station.setStationName(rs.getString(3));
					station.setPinyinCode(rs.getString(4));
					station.setRailwayBureau(rs.getString(5));
					station.setStationGrade(rs.getString(6));
					station.setAdministrativeRegion(rs.getString(7));
					station.setContactAddress(rs.getString(8));
					stationList.add(station);
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
		return stationList;
	}
	
	/**
	 * ��̬������ѯ
	 * @return
	 */
	public List<Station> findStationsByDynamic (Station u){
		

		List<Station> stationList=new ArrayList<Station>();
		Connection conn=new DbConnection().getConnection();
		  String sql="select * from tb_station where 1=1";
		  StringBuilder sb=new StringBuilder(sql);
		  if(u.getStationCode()!=null&& !"".equals(u.getStationCode())){
			 sb.append(" and StationCode like '%"+u.getStationCode()+"%'") ;  
		  }
		  if(u.getStationName()!=null && !"".equals(u.getStationName())){
			  sb.append(" and StationName='"+u.getStationName()+"'") ;
		  }
		  if(u.getStationGrade()!=null && !"".equals(u.getStationGrade())){
			  sb.append(" and StationGrade='"+u.getStationGrade()+"'") ;
		  } 
		  
		  if(u.getRailwayBureau()!=null && !"".equals(u.getRailwayBureau())){
			  sb.append(" and RailwayBureau='"+u.getRailwayBureau()+"'") ;
		  }
		  
		  if(u.getAdministrativeRegion()!=null && !"".equals(u.getAdministrativeRegion())){
			  sb.append(" and AdministrativeRegion='"+u.getAdministrativeRegion()+"'") ;
			  
		  }
		  
			try {
				Statement pst=conn.createStatement();
				ResultSet rs=pst.executeQuery(sb.toString());
				while(rs.next()){
					Station station=new Station();
					station.setsId(rs.getInt(1));
					station.setStationCode(rs.getString(2));
					station.setStationName(rs.getString(3));
					station.setPinyinCode(rs.getString(4));
					station.setRailwayBureau(rs.getString(5));
					station.setStationGrade(rs.getString(6));
					station.setAdministrativeRegion(rs.getString(7));
					station.setContactAddress(rs.getString(8));

					stationList.add(station);
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
		return stationList;
	}
	/**
	 * ɾ���û���Ϣ
	 * @param station
	 * @return
	 */
	public boolean delete(int sId[]){
		System.out.print("mnknk");
		Connection conn=new DbConnection().getConnection();
		  String sql="delete from tb_station where sid=?";
		  System.out.print("qqqqqq");
			try {
				// ���÷��Զ��ύ����
				conn.setAutoCommit(false);
				PreparedStatement pst=conn.prepareStatement(sql);
				//�������������
				for (int i = 0; i < sId.length; i++) {
					pst.setInt(1, sId[i]);
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

	public Station findStationBytId (Station s){
		
		Connection conn=new DbConnection().getConnection();
		  String sql="select * from tb_station where sId=?";
			try {
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setObject(1,s.getsId());
				ResultSet rs=pst.executeQuery();
				rs.next();
				s.setsId(rs.getInt(1));
				s.setStationCode(rs.getString(2));
				s.setStationName(rs.getString(3));
				s.setPinyinCode(rs.getString(4));
				s.setRailwayBureau(rs.getString(5));
				s.setStationGrade(rs.getString(6));
				s.setAdministrativeRegion(rs.getString(7));
				s.setContactAddress(rs.getString(8));
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
		return s;
	}
	
	
	
	public boolean update(Station s){
		Connection conn=new DbConnection().getConnection();
		  String sql="update tb_station set StationCode=?,StationName=?,PinyinCode=?,RailwayBureau=?,StationGrade=?,AdministrativeRegion=?,ContactAddress=? where sId=?";
			try {
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setObject(1,s.getStationCode());
				pst.setObject(2,s.getStationName());
				pst.setObject(3,s.getPinyinCode());
				pst.setObject(4,s.getRailwayBureau());
				pst.setObject(5,s.getStationGrade());
				pst.setObject(6,s.getAdministrativeRegion());
				pst.setObject(7,s.getContactAddress());
				pst.setObject(8,s.getsId());
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



	public int finCount() throws Exception {
		int count=0;
		Connection connection = new DbConnection().getConnection();
		String sql = "select count(*) from tb_station";
		Statement sm = connection.createStatement();
		ResultSet rs = sm.executeQuery(sql);
		if(rs.next()){
			count=rs.getInt(1);
		}
		
		return count;
	}



	public List<Station> findbypage(int begin, int pageSize) throws SQLException {
		List<Station> list=new ArrayList<>(); 
		Connection conn = new DbConnection().getConnection();
		String sql="select * from tb_station order by sId asc limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, begin);
		ps.setInt(2, pageSize);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Station station=new Station();
			station.setsId(rs.getInt(1));
			station.setStationCode(rs.getString(2));
			station.setStationName(rs.getString(3));
			station.setPinyinCode(rs.getString(4));
			station.setRailwayBureau(rs.getString(5));
			station.setStationGrade(rs.getString(6));
			station.setAdministrativeRegion(rs.getString(7));
			station.setContactAddress(rs.getString(8));
			list.add(station);
		}
		return list;
	}


	
}
