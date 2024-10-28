package com.neuedu.cj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.cj.util.DbConnection;
import com.mysql.jdbc.Statement;
import com.neuedu.cj.model.User;

public class UserDao {
    //用户登录页面
	public boolean login(User user){
		  Connection conn=new DbConnection().getConnection();
		  String sql="select*from tb_user where ulname=? and ulpass=?";
		  try {
			PreparedStatement  pst=conn.prepareStatement(sql);
			pst.setObject(1, user.getUlname());
			pst.setObject(2, user.getUlpass());
			ResultSet rs=pst.executeQuery();
			System.out.println("123");
			if(rs.next()){
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean moidify(User user){
		  Connection conn=new DbConnection().getConnection();
		  String  sql="update tb_user set ulpass=? where ulname=?";

		  try {
			PreparedStatement  pst=conn.prepareStatement(sql);
			pst.setObject(1, user.getUlpass());
			pst.setObject(2, user.getUlname());
		    int rs=pst.executeUpdate();
			
			System.out.println("123");
			if(rs>0){
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean register(User user){
		  Connection conn=new DbConnection().getConnection();
		  String sql="insert into tb_user values(null,null,?,?,?,?,?,?,?,?,?,?,?)";
		  
		  try {
			PreparedStatement  pst=conn.prepareStatement(sql);
			pst.setObject(1, user.getRealName());
			pst.setObject(2, user.getSex());
			pst.setObject(3, user.getProvice());
			pst.setObject(4, user.getCity());
			pst.setObject(5, user.getCardType());
			pst.setObject(6, user.getCardNumber());
			pst.setObject(7, user.getBirthday());
			pst.setObject(8, user.getLvkeType());
			pst.setObject(9, user.getInfo());
			pst.setObject(10, user.getUlname());
			pst.setObject(11, user.getUlpass());
			int rowCount=pst.executeUpdate();
			if(rowCount>0){
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	//用户查询
	public List<User> findAll(){
		List<User> userList=new ArrayList<User>();
		
		  Connection conn=new DbConnection().getConnection();
		  String sql="select* from tb_user";
		  
		  try {
			PreparedStatement  pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
		 while(rs.next()){
			 User user=new User();
			 user.setuId(rs.getInt(1));
			 user.setLoginName((rs.getString(1)));
			 user.setRealName(rs.getString(3));
			 user.setSex(rs.getString(4));
			 user.setProvice(rs.getString(5));
			 user.setCity(rs.getString(6));
			 user.setCardType(rs.getString(7));
			 user.setCardNumber(rs.getString(8));
			 user.setBirthday(rs.getDate(9));
			 user.setLvkeType(rs.getString(10));
			 user.setInfo(rs.getString(11));
			 user.setUlname(rs.getString(12));
			 user.setUlpass(rs.getString(13));
			 userList.add(user);
		 }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userList;
	}
	/**
	 * 动态条件查询
	 * @return
	 */
	public List<User> findUsersByDymamic(User u){
		
		List<User> userList=new ArrayList<User>();
		
		  Connection conn=new DbConnection().getConnection();
		  String sql="select* from tb_user where 1=1";
		  StringBuilder hao=new StringBuilder(sql);
		  if(u.getRealName()!=null&&!"".equals(u.getRealName())){
//			  sql+="and realName=?";需要加prepareStatement
//			  sql+="and realName="+u.getRealName();
			  hao.append(" and realName like'%"+u.getRealName()+"%'");
		  }
		  if(u.getSex()!=null&&!"".equals(u.getSex())){
//			sql+="and sex="+u.getSex();  
			  hao.append(" and sex='"+u.getSex()+"'");
		  }
		  if(u.getCardType()!=null&&!"".equals(u.getCardType())){
//				sql+="and cardType="+u.getCardType();  
			  hao.append(" and cardType='"+u.getCardType()+"'");
		  }
		  if(u.getCardNumber()!=null&&!"".equals(u.getCardNumber())){
//				sql+="and cardNumber()="+u.getCardNumber();  
			  hao.append(" and cardNumber='"+u.getCardNumber()+"'");

		  }
		  if(u.getLvkeType()!=null&&!"".equals(u.getLvkeType())){
//				sql+="and lvkeType="+u.getLvkeType();  
			  hao.append(" and lvkeType='"+u.getLvkeType()+"'");
		  }
		  
		  
		  try {
			Statement pst=(Statement) conn.createStatement();
			ResultSet rs=pst.executeQuery(hao.toString());
		    while(rs.next()){
		    	User user=new User();
				 user.setuId(rs.getInt(1));
				 user.setLoginName((rs.getString(1)));
				 user.setRealName(rs.getString(3));
				 user.setSex(rs.getString(4));
				 user.setProvice(rs.getString(5));
				 user.setCity(rs.getString(6));
				 user.setCardType(rs.getString(7));
				 user.setCardNumber(rs.getString(8));
				 user.setBirthday(rs.getDate(9));
				 user.setLvkeType(rs.getString(10));
				 user.setInfo(rs.getString(11));
				 user.setUlname(rs.getString(12));
				 user.setUlpass(rs.getString(13));
				 userList.add(user);
		 }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userList;
	
        }
	//删除
	public boolean delete(int uid[]){
		  Connection conn=new DbConnection().getConnection();
		  String sql="delete from tb_user where uid=?";
		  try {
			  //设置非自动提交
			  conn.setAutoCommit(false);
			PreparedStatement pst=conn.prepareStatement(sql);
			for(int i=0;i<uid.length;i++){
				pst.setInt(1,uid[i]);
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
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean insert(User user){
		  Connection conn=new DbConnection().getConnection();
		  String sql="insert into tb_user values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
		  
		  try {
			PreparedStatement  pst=conn.prepareStatement(sql);
			pst.setObject(1, user.getLoginName());
			pst.setObject(2, user.getRealName());
			pst.setObject(3, user.getSex());
			pst.setObject(4, user.getProvice());
			pst.setObject(5, user.getCity());
			pst.setObject(6, user.getCardType());
			pst.setObject(7, user.getCardNumber());
			pst.setObject(8, user.getBirthday());
			pst.setObject(9, user.getLvkeType());
			pst.setObject(10, user.getInfo());
			pst.setObject(11, user.getUlname());
			pst.setObject(12, user.getUlpass());
		    int rowCount=pst.executeUpdate();
			if(rowCount>0){
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
