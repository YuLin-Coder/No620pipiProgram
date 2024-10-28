package com.neuedu.cj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neuedu.cj.util.DbConnection;
import com.neuedu.cj.model.Manager;

public class ManagerDao {

	//µÇÂ¼·½·¨
	public boolean login(Manager manager){
		  Connection conn=new DbConnection().getConnection();
		  String sql="select*from tb_manager where mname=? and mpass=?";
		  try {
			PreparedStatement  pst=conn.prepareStatement(sql);
			pst.setObject(1, manager.getMname());
			pst.setObject(2, manager.getMpass());
			ResultSet rs=pst.executeQuery();
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
}
